package com.renttravel.controller;

import com.renttravel.entity.EspecialGoodsEntity;
import com.renttravel.service.EspecialGoodsService;
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
    /**
     * 特价商品列表
     *
     * @return 商品列表
     */
    @RequestMapping(value = "/especial/goods_list", method = RequestMethod.GET)
    public R especialGoodsList() {
        List<EspecialGoodsEntity> list = especialGoodsService.especialGoodsList();
        return R.ok().put("data", list);
    }
}
