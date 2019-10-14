package com.jpl.easyrider.controller;

import com.jpl.easyrider.InterfaceServices.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InstructorController {

    @Autowired
    private UserService userService;

    @GetMapping("/instructor")
    public String ShowInstructorHomePage(){
        return "/instructor-home";
    }

    @GetMapping("/instructors-descriptions")
    public String ShowInstructors(Model model) {

        model.addAttribute("users", userService.findAllByRole("ROLE_MANAGER"));

        return "instructors-descriptions";
    }
}
