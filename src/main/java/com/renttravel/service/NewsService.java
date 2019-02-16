package com.renttravel.service;

import com.baomidou.mybatisplus.service.IService;
import com.renttravel.entity.NewsEntity;

public interface NewsService extends IService<NewsEntity> {
    boolean insertNew(NewsEntity newsEntity);
}
