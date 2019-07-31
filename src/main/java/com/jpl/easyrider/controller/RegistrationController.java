package com.jpl.easyrider.controller;

import com.jpl.easyrider.InterfaceServices.UserService;
import com.jpl.easyrider.Services.UserServiceImpl;
import com.jpl.easyrider.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity <List<User>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/index")
    public String home() {
        return "index";
    }

}
