package com.renttravel.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.renttravel.entity.NewsEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NewsDao extends BaseMapper<NewsEntity> {
    List<NewsEntity> getNewsList();
}
