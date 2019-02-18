package com.renttravel.service;

import com.baomidou.mybatisplus.service.IService;
import com.renttravel.FormEntity.StatNewsCommentsOrZan;
import com.renttravel.entity.CommentsEntity;

import java.util.List;

public interface CommentsService extends IService<CommentsEntity> {
    List<StatNewsCommentsOrZan> statNewComment();
}
