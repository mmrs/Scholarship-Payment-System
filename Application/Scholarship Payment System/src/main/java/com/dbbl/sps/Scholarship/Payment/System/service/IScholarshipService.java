package com.dbbl.sps.Scholarship.Payment.System.service;

import com.dbbl.sps.Scholarship.Payment.System.model.Students;

import java.util.List;

public interface IScholarshipService {

    List<Students> prepareEligibleStudentList();

    Boolean resultGenerate();

    List<Students> getEligibleStudents();
}
