package com.renttravel.service.Impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.renttravel.dao.UserDao;
import com.renttravel.entity.UserEntity;
import com.renttravel.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 用户 Service
* created by nicking
* data: 2019/1/21
* time: 11:14
*/
@Service("UserService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {

    @Override
    public UserEntity userLogin(UserEntity user) {
        Map<String, Object> map = new HashMap<>();
        map.put("user_name",user.getUserName());
        map.put("password",user.getPassword());
        List<UserEntity> list = baseMapper.selectByMap(map);
        UserEntity userEntity = null;
        if (list.size() > 0) {
            userEntity = list.get(0);
        }
        return userEntity;
    }

    @Override
    public int userRegister(UserEntity userEntity) {
        return baseMapper.insertUser(userEntity);
    }
}
