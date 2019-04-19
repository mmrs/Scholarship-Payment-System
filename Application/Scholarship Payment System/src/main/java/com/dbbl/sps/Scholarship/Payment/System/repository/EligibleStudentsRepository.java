package com.dbbl.sps.Scholarship.Payment.System.repository;

import com.dbbl.sps.Scholarship.Payment.System.model.EligibleStudents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EligibleStudentsRepository extends JpaRepository<EligibleStudents, Integer> {

}
