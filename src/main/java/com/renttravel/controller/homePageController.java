package com.renttravel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class homePageController {

    @GetMapping(value = "/index")
    public String login() {
        return "index";
    }
}
