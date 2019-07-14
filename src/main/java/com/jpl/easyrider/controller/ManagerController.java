package com.jpl.easyrider.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ManagerController {

    @GetMapping("/manager")
    public String ShowManagerHomePage(){

        return "manager-home";
    }

}
