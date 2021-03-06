package com.renttravel.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.renttravel.entity.GoodsEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsDao extends BaseMapper<GoodsEntity> {
    List<GoodsEntity> goodsList();
}
