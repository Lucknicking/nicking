package com.renttravel.service.Impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.renttravel.FormEntity.NewsList;
import com.renttravel.FormEntity.StatNewsCommentsOrZan;
import com.renttravel.dao.NewsDao;
import com.renttravel.entity.NewsEntity;
import com.renttravel.service.CommentsService;
import com.renttravel.service.NewsService;
import com.renttravel.service.UserService;
import com.renttravel.service.ZanService;
import com.renttravel.utils.TimeToNow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
* 发布动态Service
* created by nicking
* data: 2019/2/16
* time: 14:31
*/
@Service("NewsService")
public class NewsServiceImpl extends ServiceImpl<NewsDao, NewsEntity> implements NewsService {
    @Autowired
    private UserService userService;
    @Autowired
    private CommentsService commentsService;
    @Autowired
    private ZanService zanService;
    @Override
    public boolean insertNew(NewsEntity newsEntity) {
        return this.insert(newsEntity);
    }

    @Override
    public List<NewsList> getNewsList() {
        TimeToNow formatToNowTime = new TimeToNow();
        List<StatNewsCommentsOrZan> countCommentList = commentsService.statNewComment();
        List<StatNewsCommentsOrZan> countZanList = zanService.statNewZan();
        List<NewsList> newsList = new ArrayList<>();
        List<NewsEntity> newsEntityList = baseMapper.getNewsList();
        for (NewsEntity news : newsEntityList) {
            NewsList tempNew = new NewsList();
            tempNew.setUserId(news.getUserId());
            tempNew.setImgUrl(news.getImgUrl());
            tempNew.setTitle(news.getTitle());
            tempNew.setContent(news.getContent());
            tempNew.setId(news.getId());
            tempNew.setDate(news.getCreateTime());
            tempNew.setTime(formatToNowTime.getResult(news.getCreateTime()));
            HashMap<String, Object> map = new HashMap<>();
            map.put("news_id", news.getId());
//            获取动态发布者 nickName昵称
            tempNew.setNickName(userService.selectById(news.getUserId()).getNickName());
//            获取评论数
            for (StatNewsCommentsOrZan tempStatNewsCount : countCommentList) {
                if (tempStatNewsCount.getNewsId() == news.getId()) {
                    tempNew.setTotalComment(tempStatNewsCount.getTotal());
                }
            }
//            获取点赞数
            for (StatNewsCommentsOrZan tempStatNewsCount : countZanList) {
                if (tempStatNewsCount.getNewsId() == news.getId()) {
                    tempNew.setTotalZan(tempStatNewsCount.getTotal());
                }
            }
            newsList.add(tempNew);
        }
        return newsList;
    }
}
