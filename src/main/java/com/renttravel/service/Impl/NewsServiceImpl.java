package com.renttravel.service.Impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.renttravel.dao.NewsDao;
import com.renttravel.entity.NewsEntity;
import com.renttravel.service.NewsService;
import org.springframework.stereotype.Service;

/**
* 发布动态Service
* created by nicking
* data: 2019/2/16
* time: 14:31
*/
@Service("NewsService")
public class NewsServiceImpl extends ServiceImpl<NewsDao, NewsEntity> implements NewsService {
    @Override
    public boolean insertNew(NewsEntity newsEntity) {
        return this.insert(newsEntity);
    }
}
