package com.renttravel.service;

import com.baomidou.mybatisplus.service.IService;
import com.renttravel.entity.UserEntity;

public interface UserService extends IService<UserEntity> {

    UserEntity userLogin(UserEntity user);

    int userRegister(UserEntity userEntity);
}
