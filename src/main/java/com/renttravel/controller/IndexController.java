package com.renttravel.controller;

import com.renttravel.dao.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        return "index";
    }
    @RequestMapping(value = "/api/login",method = RequestMethod.POST)
    public String login(@RequestBody User user){
        System.out.println(user);
        return "index";
    }
}
