package com.renttravel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class IndexPageController {

    @GetMapping(value = "/index")
    public String login(HttpSession session) {
        if (null != session.getAttribute("admin")){
            return "index";
        } else {
            return "adminlogin";
        }
    }
}
