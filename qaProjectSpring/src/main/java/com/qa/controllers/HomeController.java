package com.qa.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    // Return some data when a user hits the home page
    @RequestMapping("/")
    public String home() {
        return "This is the Home page";
    }
}
