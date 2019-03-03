package com.renttravel.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.renttravel.entity.EspecialGoodsEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EspecialGoodsDao extends BaseMapper<EspecialGoodsEntity> {
    List<EspecialGoodsEntity> especialList();
}
