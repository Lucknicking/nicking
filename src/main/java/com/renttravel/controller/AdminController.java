package com.renttravel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class AdminController {
    @RequestMapping(value = "/admin/index", method = RequestMethod.GET)
    public String index() {
        return "adminlogin";
    }

    @RequestMapping(value = "/admin/login", method = RequestMethod.POST)
    public String login(HttpSession session, String username, String password) {
        if (username.equals("admin") && password.equals("admin123")) {
            session.setAttribute("admin", "logined");
            return "redirect:/index";
        } else {
            return "adminlogin";
        }
    }
}
