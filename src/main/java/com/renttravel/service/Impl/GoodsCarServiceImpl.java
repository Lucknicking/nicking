package com.renttravel.service.Impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.renttravel.dao.GoodsCarDao;
import com.renttravel.entity.GoodsCarEntity;
import com.renttravel.service.GoodsCarService;
import org.springframework.stereotype.Service;

@Service("GoodsCarService")
public class GoodsCarServiceImpl extends ServiceImpl<GoodsCarDao, GoodsCarEntity> implements GoodsCarService {
}
