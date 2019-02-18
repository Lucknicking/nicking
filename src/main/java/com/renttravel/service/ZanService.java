package com.renttravel.service;

import com.baomidou.mybatisplus.service.IService;
import com.renttravel.FormEntity.StatNewsCommentsOrZan;
import com.renttravel.entity.ZanEntity;

import java.util.List;

public interface ZanService extends IService<ZanEntity> {
    List<StatNewsCommentsOrZan> statNewZan();
    boolean InsertOrDelete(ZanEntity zan);
}
