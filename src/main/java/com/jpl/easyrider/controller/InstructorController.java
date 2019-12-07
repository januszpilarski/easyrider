package com.jpl.easyrider.controller;

import com.jpl.easyrider.InterfaceServices.UserService;
import com.jpl.easyrider.dto.UserDtoOutgoing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

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

        List<UserDtoOutgoing> instructors = userService.findAllByRole("ROLE_RIDER");

        model.addAttribute("users", instructors);

        return "instructors-descriptions";
    }
}
