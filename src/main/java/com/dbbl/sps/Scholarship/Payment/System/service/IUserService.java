package com.dbbl.sps.Scholarship.Payment.System.service;

import com.dbbl.sps.Scholarship.Payment.System.model.Students;
import com.dbbl.sps.Scholarship.Payment.System.model.Users;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    Users getUserAgainstPassword(Users users);

    Optional<Users> getUserById(String userId);

    Students getStudentByUserId(Integer userId);

    Users findByUserName(String userName);

    void saveStudent(Students students);

    void saveUser(Users users);

    int getMaxUserId();

    int GetMaxStudentId();

    List<Students> getAllStudents();
}
