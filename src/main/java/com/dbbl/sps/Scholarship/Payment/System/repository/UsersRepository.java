package com.dbbl.sps.Scholarship.Payment.System.repository;

import com.dbbl.sps.Scholarship.Payment.System.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

    Users findByUserNameAndPassword(String userName, String password);
}
