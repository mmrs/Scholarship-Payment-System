package com.dbbl.sps.Scholarship.Payment.System.controller;

import com.dbbl.sps.Scholarship.Payment.System.model.Students;
import com.dbbl.sps.Scholarship.Payment.System.service.ScholarshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class ScholarshipController {

    @Autowired
    ScholarshipService scholarshipService;

    @GetMapping("scholarship/generate")
    List<Students> ScholarshipGenerate() {
        return  scholarshipService.prepareEligibleStudentList();
    }
}
