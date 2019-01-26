package com.renttravel.service.Impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.renttravel.dao.UserDao;
import com.renttravel.entity.UserEntity;
import com.renttravel.service.UserService;
import org.springframework.stereotype.Service;

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
        UserEntity userEntity = baseMapper.queryByUserName(user.getUserName());
        if ((null != userEntity) && (userEntity.getPassword()).equals(user.getPassword())) {
            return userEntity;
        }
        return null;
    }

    @Override
    public int userRegister(UserEntity userEntity) {
        return baseMapper.insertUser(userEntity);
    }
}
