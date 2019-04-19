package com.dbbl.sps.Scholarship.Payment.System.repository;

import com.dbbl.sps.Scholarship.Payment.System.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentsRepository extends JpaRepository<Students, Integer> {
    Students findByUserId(Integer userId);
    @Query(value = "SELECT MAX(id) from students", nativeQuery = true)
    int getMaxId();
}
