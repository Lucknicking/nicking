package com.renttravel.service;

import com.baomidou.mybatisplus.service.IService;
import com.renttravel.entity.GoodsEntity;

import java.util.List;

public interface GoodsService extends IService<GoodsEntity> {
    List<GoodsEntity> GoodsList();
}
