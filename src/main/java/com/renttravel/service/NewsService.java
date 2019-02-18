package com.renttravel.service;

import com.baomidou.mybatisplus.service.IService;
import com.renttravel.FormEntity.NewsList;
import com.renttravel.entity.NewsEntity;

import java.util.List;

public interface NewsService extends IService<NewsEntity> {
    boolean insertNew(NewsEntity newsEntity);
    List<NewsList> getNewsList();
}
