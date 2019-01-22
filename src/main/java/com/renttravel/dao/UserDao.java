package com.renttravel.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.renttravel.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDao extends BaseMapper<UserEntity> {
    UserEntity queryByUserName(@Param("userName") String userName);
}
