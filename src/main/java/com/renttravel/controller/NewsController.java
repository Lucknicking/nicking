package com.renttravel.controller;

import com.renttravel.FormEntity.CommentsForm;
import com.renttravel.FormEntity.NewsList;
import com.renttravel.entity.CommentsEntity;
import com.renttravel.entity.NewsEntity;
import com.renttravel.entity.ZanEntity;
import com.renttravel.service.CommentsService;
import com.renttravel.service.NewsService;
import com.renttravel.service.ZanService;
import com.renttravel.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private CommentsService commentsService;
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
     * 评论
     */
    @RequestMapping(value = "/news/send/comment", method = RequestMethod.POST)
    public R sendComment(@RequestBody CommentsEntity comment) {
        boolean flag = commentsService.insert(comment);
        List<CommentsForm> list = commentsService.commentsList(comment.getNewsId());
        if(flag) {
            return R.ok().put("data", list);
        }
        return R.error();
    }

    /**
     * 评论列表
     */
    @RequestMapping(value = "/news/comment/list", method = RequestMethod.GET)
    public R commentList(long newsId) {
        List<CommentsForm> list = commentsService.commentsList(newsId);
        return R.ok().put("data", list);
    }

    /**
     * 删除评论
     */
    @RequestMapping(value = "/news/comment/delete", method = RequestMethod.GET)
    public R deleteComment(long id, long newsId) {
        boolean flag = commentsService.deleteById(id);
        List<CommentsForm> list = commentsService.commentsList(newsId);
        return R.ok().put("data", list);
    }

    /**
     * 删除动态
     */
    @RequestMapping(value = "/news/delete", method = RequestMethod.GET)
    public R deleteNew(long id) {
        boolean flag = newsService.deleteById(id);
        Map<String, Object> map = new HashMap<>();
        map.put("news_id", id);
        commentsService.deleteByMap(map);
        zanService.deleteByMap(map);
        List<NewsList> list = newsService.getNewsList();
        return R.ok().put("data", list);
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
