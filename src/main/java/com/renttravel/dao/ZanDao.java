package com.renttravel.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.renttravel.FormEntity.StatNewsCommentsOrZan;
import com.renttravel.entity.ZanEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ZanDao extends BaseMapper<ZanEntity> {
    List<StatNewsCommentsOrZan> totalZan();
}
