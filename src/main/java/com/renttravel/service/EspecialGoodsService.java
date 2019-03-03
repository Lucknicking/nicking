package com.renttravel.service;

import com.baomidou.mybatisplus.service.IService;
import com.renttravel.entity.EspecialGoodsEntity;

import java.util.List;

public interface EspecialGoodsService extends IService<EspecialGoodsEntity> {
    List<EspecialGoodsEntity> especialGoodsList();
}
