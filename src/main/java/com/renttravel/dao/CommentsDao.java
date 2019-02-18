package com.renttravel.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.renttravel.FormEntity.StatNewsCommentsOrZan;
import com.renttravel.entity.CommentsEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentsDao extends BaseMapper<CommentsEntity> {
    List<StatNewsCommentsOrZan> totalComments();
}
