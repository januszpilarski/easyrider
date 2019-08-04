package com.jpl.easyrider.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InstructorController {

    @GetMapping("/instructor")
    public String ShowInstructorHomePage(){
        return "/zinstructor-home";
    }
}
