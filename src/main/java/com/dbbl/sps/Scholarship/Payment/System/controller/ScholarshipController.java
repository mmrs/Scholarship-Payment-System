package com.dbbl.sps.Scholarship.Payment.System.controller;

import com.dbbl.sps.Scholarship.Payment.System.model.EligibileStudents;
import com.dbbl.sps.Scholarship.Payment.System.model.Students;
import com.dbbl.sps.Scholarship.Payment.System.repository.EligibleStudentsRepository;
import com.dbbl.sps.Scholarship.Payment.System.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ScholarshipController {

    @Autowired
    StudentsRepository studentsRepository;
    @Autowired
    EligibleStudentsRepository eligibleStudentsRepository;

    @GetMapping("scholarship/generate")
    List<Students> ScholarshipGenerate() {
        List<Students> allStudents = studentsRepository.findAll(Sort.by("hscGpaWithoutFourthSubject",
                "hscGpaWithFourthSubject",
                "sscGpaWithoutFourthSubject",
                "sscGpaWithFourthSubject"));

        List<Students> male = new ArrayList<Students>();
        List<Students> female = new ArrayList<Students>();
        //filter male and female
        for (int i = allStudents.size() - 1; i >= 0; i--) {
            if (allStudents.get(i).getGender().toLowerCase().startsWith("f")) {
                female.add(allStudents.get(i));
            } else {
                male.add(allStudents.get(i));
            }
        }

        int maxAllowed = (int) Math.ceil((double)allStudents.size() /2);
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
            System.out.println(selectedStudents);
        }

        for(int i=0;i<selectedStudents.size();i++){
         eligibleStudentsRepository.save(new EligibileStudents(i+1, selectedStudents.get(i).getId()));
        }

        return selectedStudents;
    }
}
