package com.renttravel.service.Impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.renttravel.dao.GoodsDao;
import com.renttravel.entity.GoodsEntity;
import com.renttravel.service.GoodsService;
import org.springframework.stereotype.Service;

@Service("GoodsService")
public class GoodsServiceImpl extends ServiceImpl<GoodsDao, GoodsEntity> implements GoodsService {
}
