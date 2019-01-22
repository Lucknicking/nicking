package com.renttravel.service;

import com.baomidou.mybatisplus.service.IService;
import com.renttravel.FormEntity.LoginForm;
import com.renttravel.entity.UserEntity;

public interface UserService extends IService<UserEntity> {

    UserEntity userLogin(UserEntity user);
}
