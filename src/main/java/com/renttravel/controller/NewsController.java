package com.renttravel.controller;

import com.renttravel.FormEntity.NewsList;
import com.renttravel.entity.NewsEntity;
import com.renttravel.entity.ZanEntity;
import com.renttravel.service.NewsService;
import com.renttravel.service.ZanService;
import com.renttravel.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户发布内容
 * created by nicking
 * data: 2019/2/16
 * time: 13:51
 */
@RestController
@RequestMapping("/api")
public class NewsController {

    @Autowired
    private NewsService newsService;
    @Autowired
    private ZanService zanService;
    /**
     * 发布动态
     */
    @RequestMapping(value = "/news/send", method = RequestMethod.POST)
    public R insertNews(@RequestBody NewsEntity news) {
        boolean flag = newsService.insertNew(news);
        if(flag) {
            return R.ok();
        }
        return R.error();
    }

    /**
     * 给动态点赞
     * true 代表点赞
     * false 代表取消赞
     */
    @RequestMapping(value = "/news/approvel", method = RequestMethod.GET)
    public R approvelNews(ZanEntity zan) {
        boolean flag = zanService.InsertOrDelete(zan);
        return R.ok().put("data", flag);
    }

    /**
     * 获取所有动态列表
     */
    @RequestMapping(value = "/news/list", method = RequestMethod.GET)
    public R getNewsList() {
        List<NewsList> newsList  = newsService.getNewsList();
        return R.ok().put("data", newsList);
    }
}
