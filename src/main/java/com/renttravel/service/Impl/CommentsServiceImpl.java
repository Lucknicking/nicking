package com.renttravel.service.Impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.renttravel.FormEntity.CommentsForm;
import com.renttravel.FormEntity.StatNewsCommentsOrZan;
import com.renttravel.dao.CommentsDao;
import com.renttravel.entity.CommentsEntity;
import com.renttravel.entity.UserEntity;
import com.renttravel.service.CommentsService;
import com.renttravel.service.UserService;
import com.renttravel.utils.TimeToNow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("CommentsService")
public class CommentsServiceImpl extends ServiceImpl<CommentsDao, CommentsEntity> implements CommentsService {

    @Autowired
    private UserService userService;

    @Override
    public List<StatNewsCommentsOrZan> statNewComment() {
        return baseMapper.totalComments();
    }

    @Override
    public List<CommentsForm> commentsList(long newsId) {
        TimeToNow timeFormat = new TimeToNow();
        List<CommentsForm> resultList = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("news_id", newsId);
        List<CommentsEntity> commentList = this.selectByMap(map);
        for (CommentsEntity item : commentList) {
            CommentsForm resultComments = new CommentsForm();
            UserEntity user = userService.selectById(item.getUserId());
            resultComments.setId(item.getId());
            resultComments.setComments(item.getComments());
            resultComments.setImgUrl(user.getImgUrl());
            resultComments.setNickName(user.getNickName());
            resultComments.setUserId(user.getId());
            resultComments.setTime(timeFormat.getResult(item.getCreateTime()));
            resultList.add(resultComments);
        }
        return resultList;
    }
}
