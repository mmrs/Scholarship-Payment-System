package com.dbbl.sps.Scholarship.Payment.System.controller;


import com.dbbl.sps.Scholarship.Payment.System.model.Users;
import com.dbbl.sps.Scholarship.Payment.System.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    UsersRepository usersRepository;

    @GetMapping("/")
    public String login(Model model){
        model.addAttribute("login",new Users());
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(Users users){
        System.out.println(users.toString());
        System.out.println(usersRepository.findAll());
        return "redirect:/";
    }
}
