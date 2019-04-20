package com.dbbl.sps.Scholarship.Payment.System.service;

import com.dbbl.sps.Scholarship.Payment.System.model.EligibleStudents;
import com.dbbl.sps.Scholarship.Payment.System.model.Students;
import com.dbbl.sps.Scholarship.Payment.System.repository.EligibleStudentsRepository;
import com.dbbl.sps.Scholarship.Payment.System.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ScholarshipService implements IScholarshipService {

    @Autowired
    StudentsRepository studentsRepository;
    @Autowired
    EligibleStudentsRepository eligibleStudentsRepository;

    @Override
    public List<Students> prepareEligibleStudentList() {
        List<Students> allStudents = studentsRepository.findAll(Sort.by("hscGpaWithoutFourthSubject",
                "hscGpaWithFourthSubject",
                "sscGpaWithoutFourthSubject",
                "sscGpaWithFourthSubject"));

        List<Students> male = new ArrayList<>();
        List<Students> female = new ArrayList<>();
        //filter male and female
        for (int i = allStudents.size() - 1; i >= 0; i--) {
            if (allStudents.get(i).getGender().toLowerCase().startsWith("f")) {
                female.add(allStudents.get(i));
            } else {
                male.add(allStudents.get(i));
            }
        }

        int maxAllowed = (int) Math.ceil((double) allStudents.size() / 2);
        List<Students> selectedStudents = new ArrayList<>();
        //select 50/50 from both
        for (int i = 0, j = 0, selected = 0; selected <= maxAllowed; i++, j++) {
            //apply filtering here
            if (i < female.size()) {
                selected++;
                selectedStudents.add(female.get(i));
            }
            if (j < male.size()) {
                selected++;
                selectedStudents.add(male.get(j));
            }
            if (selected == maxAllowed) {
                break;
            }
        }

        eligibleStudentsRepository.deleteAll();
        for (int i = 0; i < selectedStudents.size(); i++) {
            EligibleStudents newItem = new EligibleStudents(i + 1, selectedStudents.get(i).getId());
            eligibleStudentsRepository.save(newItem);
        }

        return getEligibleStudents();
    }

    @Override
    public Boolean resultGenerated() {
        Boolean result = eligibleStudentsRepository.findAll().size() > 0;
        return result;
    }

    @Override
    public List<Students> getEligibleStudents() {
        List<EligibleStudents> eligibleStudentsList = eligibleStudentsRepository.findAll();
        List<Students> studentsList = new ArrayList<Students>();
        for (int i = 0; i < eligibleStudentsList.size(); i++) {
            Optional<Students> students = studentsRepository.findById(eligibleStudentsList.get(i).getStudentId());
            if (students.isPresent()) {
                studentsList.add(students.get());
            }
        }
        return  studentsList;
    }
}
