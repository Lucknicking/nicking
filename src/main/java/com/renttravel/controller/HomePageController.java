package com.renttravel.controller;

import com.renttravel.entity.EspecialGoodsEntity;
import com.renttravel.entity.GoodsEntity;
import com.renttravel.service.EspecialGoodsService;
import com.renttravel.service.GoodsService;
import com.renttravel.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 首页所有API请求
 * created by nicking
 * data: 2019/2/27
 * time: 20:14
 */
@RestController
@RequestMapping("/api")
public class HomePageController {

    @Autowired
    private EspecialGoodsService especialGoodsService;
    @Autowired
    private GoodsService goodsService;
    /**
     * 特价商品列表
     *
     * @return 特价商品列表
     */
    @RequestMapping(value = "/especial/goods_list", method = RequestMethod.GET)
    public R especialGoodsList() {
        List<EspecialGoodsEntity> list = especialGoodsService.especialGoodsList();
        return R.ok().put("data", list);
    }

    /**
     * 商品列表
     *
     * @return 商品列表
     */
    @RequestMapping(value = "/goods/goods_list", method = RequestMethod.GET)
    public R GoodsList() {
        List<GoodsEntity> list = goodsService.GoodsList();
        return R.ok().put("data", list);
    }
}
