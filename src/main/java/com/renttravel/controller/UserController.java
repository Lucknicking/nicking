package com.renttravel.controller;

import com.renttravel.entity.UserEntity;
import com.renttravel.interceptor.SysLog;
import com.renttravel.service.UserService;
import com.renttravel.utils.MD5;
import com.renttravel.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 登录
     *
     * @param user
     * @return 登录成功 返回用户实体类信息
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public R login(HttpSession session, @RequestBody UserEntity user) {
        user.setPassword(MD5.MD5(user.getPassword()));
        UserEntity userEntity = userService.userLogin(user);
        if (null != userEntity) {
            session.setAttribute(String.valueOf(user.getId()), userEntity.getUserName());
            return R.ok().put("data", userEntity);
        }
        return R.error(401, "账号或密码错误");
    }

    /**
     * 修改用户信息
     */
    @SysLog("修改用户信息")
    @RequestMapping(value = "/edit/user/info", method = RequestMethod.POST)
    public R editUserInfo(@RequestBody UserEntity user) {
        boolean flag = userService.updateById(user);
        return R.ok().put("id", flag);
    }

    /**
     * 用户注册
     * created by nicking
     * data: 2019/1/26
     * time: 14:15
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public R register(@RequestBody UserEntity user) {
        user.setPassword(MD5.MD5(user.getPassword()));
        int userId = userService.userRegister(user);
        return R.ok().put("id", userId);
    }
}
