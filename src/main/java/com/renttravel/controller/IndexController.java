package com.renttravel.controller;

import com.renttravel.FormEntity.LoginForm;
import com.renttravel.entity.UserEntity;
import com.renttravel.service.UserService;
import com.renttravel.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class IndexController {

    @Autowired
    private UserService userService;

    /**
     * 登录
     * @param user
     * @return 登录成功 返回用户实体类信息
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public R login(@RequestBody UserEntity user){
        userService.userLogin(user);
        return R.ok();
    }
}