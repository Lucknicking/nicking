package com.renttravel.controller;

import com.renttravel.FormEntity.OrderForm;
import com.renttravel.entity.OrderEntity;
import com.renttravel.service.OrderService;
import com.renttravel.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 下订单
 * created by nicking
 * data: 2019/3/3
 * time: 17:43
 */
@RestController
@RequestMapping("/api")
public class OrderController {
    @Autowired
    private OrderService orderService;

    /**
     * 下单
     */
    @RequestMapping(value = "/buy/goods", method = RequestMethod.POST)
    public R doOrder(@RequestBody List<OrderForm> entList) {
        if (entList.size()>0) {
            for (OrderForm orderForm : entList) {
                OrderEntity orderEntity = new OrderEntity();
                orderEntity.setCountNum(orderForm.getCount());
                orderEntity.setGoodsId(orderForm.getGoodsId());
                orderEntity.setUserId(orderForm.getUserId());
                orderEntity.setTotalPrice(orderForm.getCount()*orderForm.getPrice());
                orderService.insert(orderEntity);
            }
        } else {
            return R.error("还没有选择商品哦");
        }

        return R.ok();
    }
}
