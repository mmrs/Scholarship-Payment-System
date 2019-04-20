package com.dbbl.sps.Scholarship.Payment.System.controller;


import com.dbbl.sps.Scholarship.Payment.System.model.RegisterUser;
import com.dbbl.sps.Scholarship.Payment.System.model.Students;
import com.dbbl.sps.Scholarship.Payment.System.model.Users;
import com.dbbl.sps.Scholarship.Payment.System.service.ScholarshipService;
import com.dbbl.sps.Scholarship.Payment.System.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    ScholarshipService scholarshipService;

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
    public String loginUser(Users users) {
        Users dbUser = userService.getUserAgainstPassword(users);
        if (dbUser == null) {
            return "redirect:/login?error=" + "Wrong Username or Password";
        } else {
            if (dbUser.getUserType().equals("a")) {
                return "redirect:/studentList";
            } else {
                if (scholarshipService.resultGenerated()) {
                    return "redirect:/result?ust=s";
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

            Optional<Users> users = userService.getUserById(userId);
            if (users.isPresent()) {
                registerUser.setUsers(users.get());
                Students students = userService.getStudentByUserId(users.get().getId());
                registerUser.setStudents(students);
                model.addAttribute("RegisterUser", registerUser);
                model.addAttribute("ust", true);
            }
        }
        return "register";
    }

    @PostMapping("/register")
    public String register(Model model, Users users, Students students) {
        RegisterUser registerUser = new RegisterUser();
        model.addAttribute("RegisterUser", registerUser);
        Users dbUser = userService.findByUserName(users.getUserName());
        if (dbUser != null) {
            if (dbUser.getPassword().equals(users.getPassword())) {
                students.setUserId(dbUser.getId());
                Students current = userService.getStudentByUserId(students.getUserId());
                if(students.getGender() == null || students.getGender().isEmpty()){
                    students.setGender(current.getGender());
                }
                userService.saveStudent(students);
                return "redirect:/success?message=Information updated successfully.";
            }
            registerUser.setUsers(users);
            registerUser.setStudents(students);
            return "redirect:/register?error=" + "User already registered";
        }
        users.setId(userService.getMaxUserId() + 1);
        users.setUserType("s");
        registerUser.setUsers(users);
        students.setId(userService.GetMaxStudentId() + 1);
        students.setUserId(users.getId());
        registerUser.setStudents(students);
        try {
            userService.saveUser(users);
            userService.saveStudent(students);
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
        model.addAttribute("students", userService.getAllStudents());
        return "studentList";
    }

    @GetMapping("/result")
    public String Result(Model model, String ust) {

        List<Students> studentsList = scholarshipService.getEligibleStudents();
        model.addAttribute("students", studentsList);
        model.addAttribute("ust",ust);
        return "resultList";
    }

    @GetMapping("/logout")
    public String logout(){
        return "redirect:/";
    }
}
