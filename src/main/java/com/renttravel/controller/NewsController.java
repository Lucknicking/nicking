package com.renttravel.controller;

import com.renttravel.entity.NewsEntity;
import com.renttravel.service.NewsService;
import com.renttravel.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    /**
     * 发布动态
     * created by nicking
     * data: 2019/2/16
     * time: 13:56
     */
    @RequestMapping(value = "/news/send", method = RequestMethod.POST)
    public R getNewsList(@RequestBody NewsEntity news) {
        boolean flag = newsService.insertNew(news);
        if(flag) {
            return R.ok();
        }
        return R.error();
    }
}
