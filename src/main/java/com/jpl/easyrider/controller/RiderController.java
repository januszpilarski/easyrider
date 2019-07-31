package com.jpl.easyrider.controller;

import com.jpl.easyrider.calendar.GoogleCalendar;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Date;

@Controller
public class RiderController {

    @GetMapping("/riders")
    public String ShowRiderHomePage(ModelMap model) {
        model.put("time", new Date());
        return "home";
    }

    @GetMapping("/dates")
    public ResponseEntity ShowFreeDates() throws IOException, GeneralSecurityException {
        return ResponseEntity.ok(GoogleCalendar.getDates());
    }
}
