package com.dbbl.sps.Scholarship.Payment.System.controller;


import com.dbbl.sps.Scholarship.Payment.System.model.EligibleStudents;
import com.dbbl.sps.Scholarship.Payment.System.model.RegisterUser;
import com.dbbl.sps.Scholarship.Payment.System.model.Students;
import com.dbbl.sps.Scholarship.Payment.System.model.Users;
import com.dbbl.sps.Scholarship.Payment.System.repository.EligibleStudentsRepository;
import com.dbbl.sps.Scholarship.Payment.System.repository.StudentsRepository;
import com.dbbl.sps.Scholarship.Payment.System.repository.UsersRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    UsersRepository usersRepository;
    @Autowired
    StudentsRepository studentsRepository;
    @Autowired
    EligibleStudentsRepository eligibleStudentsRepository;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new Users());
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(Model model, Users users) {
        System.out.println(usersRepository.findByUserNameAndPassword(users.getUserName(), users.getPassword()));
        Users dbUser = usersRepository.findByUserNameAndPassword(users.getUserName(), users.getPassword());
        if (dbUser == null) {
            return "redirect:/login?error=" + "Wrong Username or Password";
        } else {
            if (dbUser.getUserType().equals("a")) {
                return "redirect:/studentList";
            }
            else{
                if(eligibleStudentsRepository.findAll().size() > 0){
                    return "redirect:/result";
                }
            }
            return "redirect:/register?userId=" + dbUser.getId() + "&user=edit";
        }
    }

    @GetMapping("/register")
    public String register(Model model, String userId) {
        RegisterUser registerUser = new RegisterUser();
        if (!model.containsAttribute("RegisterUser")) {
            registerUser.setUsers(new Users());
            registerUser.setStudents(new Students());
            model.addAttribute("RegisterUser", registerUser);
        }
        if (userId != null && !userId.isEmpty()) {
            Integer id = Integer.parseInt(userId);
            Optional<Users> users = usersRepository.findById(id);
            if (users.isPresent()) {
                registerUser.setUsers(users.get());
                Students students = studentsRepository.findByUserId(users.get().getId());
                registerUser.setStudents(students);
                model.addAttribute("RegisterUser", registerUser);
            }
        }
        return "register";
    }

    @PostMapping("/register")
    public String register(Model model, Users users, Students students) {
        RegisterUser registerUser = new RegisterUser();
        model.addAttribute("RegisterUser", registerUser);
        Users dbUser = usersRepository.findByUserName(users.getUserName());
        if (dbUser != null) {
            if (dbUser.getPassword().equals(users.getPassword())) {
//                users.setId(dbUser.getId());
//                usersRepository.save(users);
                students.setUserId(dbUser.getId());
                studentsRepository.save(students);
                return "redirect:/success?message=Information updated successfully.";
            }
            registerUser.setUsers(users);
            registerUser.setStudents(students);
            return "redirect:/register?error=" + "User already registered";
        }
        users.setId(usersRepository.getMaxId() + 1);
        users.setUserType("s");
        registerUser.setUsers(users);
        students.setId(studentsRepository.getMaxId() + 1);
        students.setUserId(users.getId());
        registerUser.setStudents(students);
        try {
            usersRepository.save(users);
            studentsRepository.save(students);
        } catch (Exception ex) {
            return "redirect:/register?error=" + ex.getMessage();
        }
        return "redirect:/success?message=Congratulations!! You have been registered successfully.";
    }

    @GetMapping("/success")
    public String success(Model model, String message) {
        model.addAttribute("message", message);
        return "success";
    }

    @GetMapping("/studentList")
    public String studentList(Model model) {
        model.addAttribute("students", studentsRepository.findAll());
        return "studentList";
    }

    @GetMapping("/result")
    public String Result(Model model) {

        List<EligibleStudents> eligibleStudentsList = eligibleStudentsRepository.findAll();
        List<Students> studentsList = new ArrayList<Students>();
        for (int i = 0; i < eligibleStudentsList.size(); i++) {
            Optional<Students> students = studentsRepository.findById(eligibleStudentsList.get(i).getStudentId());
            if (students.isPresent()) {
                studentsList.add(students.get());
            }
        }

        model.addAttribute("students", studentsList);
        return "resultList";
    }
}
