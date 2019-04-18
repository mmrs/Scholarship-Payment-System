package com.dbbl.sps.Scholarship.Payment.System.repository;

import com.dbbl.sps.Scholarship.Payment.System.model.EligibileStudents;
import com.dbbl.sps.Scholarship.Payment.System.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EligibleStudentsRepository extends JpaRepository<EligibileStudents, Integer> {

}
