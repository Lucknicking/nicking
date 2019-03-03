package com.renttravel.service.Impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.renttravel.dao.OrderDao;
import com.renttravel.entity.OrderEntity;
import com.renttravel.service.OrderService;
import org.springframework.stereotype.Service;

@Service("OrderService")
public class OrderServiceImpl extends ServiceImpl<OrderDao, OrderEntity> implements OrderService {
}
