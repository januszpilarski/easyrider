package com.jpl.easyrider.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String showHomePage() {
        return "landing";
    }

    @GetMapping("/access-denied")
    public String showAccessDenied() {
        return "/error/access-denied";
    }
}
