package com.dbbl.sps.Scholarship.Payment.System.repository;

import com.dbbl.sps.Scholarship.Payment.System.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

    Users findByUserNameAndPassword(String userName, String password);
    Users findByUserName(String userName);

    @Query(value = "SELECT MAX(id) from users", nativeQuery = true)
    int getMaxId();
}
