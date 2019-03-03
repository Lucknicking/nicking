package com.renttravel.service.Impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.renttravel.dao.EspecialGoodsDao;
import com.renttravel.entity.EspecialGoodsEntity;
import com.renttravel.service.EspecialGoodsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("EspecialGoodsService")
public class EspecialGoodsServiceImpl extends ServiceImpl<EspecialGoodsDao, EspecialGoodsEntity> implements EspecialGoodsService {
    @Override
    public List<EspecialGoodsEntity> especialGoodsList() {
        return baseMapper.especialList();
    }
}
