package com.jpl.easyrider.controller;

import com.jpl.easyrider.InterfaceServices.DBFileService;
import com.jpl.easyrider.InterfaceServices.UserService;
import com.jpl.easyrider.domain.DBFile;
import com.jpl.easyrider.domain.User;
import com.jpl.easyrider.dto.UserDtoIngoing;
import com.jpl.easyrider.dto.UserDtoOutgoing;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class InstructorController {

    @Autowired
    private UserService userService;

    @Autowired
    private DBFileService dbFileService;

    @GetMapping("/instructor")
    public String ShowInstructorHomePage(){
        return "/instructor-home";
    }

    @GetMapping("/instructors-descriptions")
    public String ShowInstructors(Model model) {

        DBFile image = dbFileService.findDBFileByID(2);

        String base64EncodedImage = Base64.encodeBase64String(image.getData());

        List<UserDtoOutgoing> instructors = userService.findAllByRole("ROLE_RIDER");

//        model.addAttribute("users", userService.findAllByRole("ROLE_RIDER"));
        model.addAttribute("images", base64EncodedImage);

        model.addAttribute("users", instructors);

        return "instructors-descriptions";
    }
}
