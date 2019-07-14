package com.jpl.easyrider.controller;

import com.jpl.easyrider.Services.UserDaoImpl;
import com.jpl.easyrider.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class RegistrationController {

    @Autowired
    private UserDaoImpl userService;

    @GetMapping("/users")
    public ResponseEntity <List<User>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/index")
    public String home() {
        return "index";
    }

}
