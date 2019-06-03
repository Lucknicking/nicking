package com.renttravel.controller;

import com.renttravel.FormEntity.FinishOrder;
import com.renttravel.FormEntity.OrderForm;
import com.renttravel.entity.EspecialGoodsEntity;
import com.renttravel.entity.OrderEntity;
import com.renttravel.service.EspecialGoodsService;
import com.renttravel.service.GoodsCarService;
import com.renttravel.service.OrderService;
import com.renttravel.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private GoodsCarService goodsCarService;
    @Autowired
    private EspecialGoodsService especialGoodsService;

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
                goodsCarService.deleteById(orderForm.getCarId());
            }
        } else {
            return R.error("还没有选择商品哦");
        }

        return R.ok();
    }

    /**
     * 获取完成的订单列表
     */
    @RequestMapping(value = "/order/finish/list", method = RequestMethod.GET)
    public R finishOrderList(long userId) {
        List<FinishOrder> resultList = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("user_id", userId);
        List<OrderEntity> list = orderService.selectByMap(map);
        for (OrderEntity itemList : list) {
            FinishOrder finishOrder = new FinishOrder();
            EspecialGoodsEntity especialGoodsEntity =  especialGoodsService.selectById(itemList.getGoodsId());
            finishOrder.setId(itemList.getId());
            finishOrder.setCount(itemList.getCountNum());
            finishOrder.setPrice(itemList.getTotalPrice());
            finishOrder.setTitle(especialGoodsEntity.getTitle());
            finishOrder.setImgUrl(especialGoodsEntity.getImgUrl());
            finishOrder.setGoodsId(especialGoodsEntity.getId());
            resultList.add(finishOrder);
        }
        return R.ok().put("data", resultList);
    }
}
