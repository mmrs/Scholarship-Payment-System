package com.dbbl.sps.Scholarship.Payment.System.controller;


import com.dbbl.sps.Scholarship.Payment.System.model.Users;
import com.dbbl.sps.Scholarship.Payment.System.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    UsersRepository usersRepository;

    @GetMapping("/")
    public String index() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("loginUser", new Users());
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(Model model, Users users) {
        System.out.println(usersRepository.findByUserNameAndPassword(users.getUserName(), users.getPassword()));
        if (usersRepository.findByUserNameAndPassword(users.getUserName(), users.getPassword()) == null) {
            model.addAttribute("logError", "logError");
            return "redirect:/login";
        } else {
            return "/register";
        }
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("register", new Users());
        return "register";
    }

    @PostMapping("/register")
    public String register(Users users) {
        System.out.println(users.toString());
        System.out.println(usersRepository.findAll());
        return "redirect:/";
    }
}
