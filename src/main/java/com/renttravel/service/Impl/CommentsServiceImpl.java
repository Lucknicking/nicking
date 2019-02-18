package com.renttravel.service.Impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.renttravel.FormEntity.StatNewsCommentsOrZan;
import com.renttravel.dao.CommentsDao;
import com.renttravel.entity.CommentsEntity;
import com.renttravel.service.CommentsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CommentsService")
public class CommentsServiceImpl extends ServiceImpl<CommentsDao, CommentsEntity> implements CommentsService {

    @Override
    public List<StatNewsCommentsOrZan> statNewComment() {
        return baseMapper.totalComments();
    }
}
