package com.renttravel.service.Impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.renttravel.dao.GoodsDao;
import com.renttravel.entity.GoodsEntity;
import com.renttravel.service.GoodsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("GoodsService")
public class GoodsServiceImpl extends ServiceImpl<GoodsDao, GoodsEntity> implements GoodsService {
    @Override
    public List<GoodsEntity> GoodsList() {
        return baseMapper.goodsList();
    }
}
