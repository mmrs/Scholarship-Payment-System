package com.dbbl.sps.Scholarship.Payment.System.service;

import com.dbbl.sps.Scholarship.Payment.System.model.Students;
import com.dbbl.sps.Scholarship.Payment.System.model.Users;
import com.dbbl.sps.Scholarship.Payment.System.repository.StudentsRepository;
import com.dbbl.sps.Scholarship.Payment.System.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    UsersRepository usersRepository;
    @Autowired
    StudentsRepository studentsRepository;

    @Override
    public Users getUserAgainstPassword(Users users) {
        Users dbUser = usersRepository.findByUserNameAndPassword(users.getUserName(), users.getPassword());
        return dbUser;
    }

    @Override
    public Optional<Users> getUserById(String userId) {
        Integer id = Integer.parseInt(userId);
        Optional<Users> users = usersRepository.findById(id);
        return users;
    }

    @Override
    public Students getStudentByUserId(Integer userId) {
        return studentsRepository.findByUserId(userId);
    }

    @Override
    public Users findByUserName(String userName) {
        return usersRepository.findByUserName(userName);
    }

    @Override
    public void saveStudent(Students students) {
        studentsRepository.save(students);
    }

    @Override
    public void saveUser(Users users) {
        usersRepository.save(users);
    }

    @Override
    public int getMaxUserId() {
        return usersRepository.getMaxId();
    }

    @Override
    public int GetMaxStudentId() {
        return studentsRepository.getMaxId();
    }

    @Override
    public List<Students> getAllStudents() {
        return studentsRepository.findAll();
    }
}
