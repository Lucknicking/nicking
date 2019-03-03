package com.renttravel.controller;

import com.renttravel.FormEntity.CarListForm;
import com.renttravel.entity.EspecialGoodsEntity;
import com.renttravel.entity.GoodsCarEntity;
import com.renttravel.interceptor.SysLog;
import com.renttravel.service.EspecialGoodsService;
import com.renttravel.service.GoodsCarService;
import com.renttravel.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * 购物车逻辑
 * created by nicking
 * data: 2019/2/28
 * time: 15:51
 */
@RestController
@RequestMapping("/api")
public class GoodsCarController {

    @Autowired
    private GoodsCarService goodsCarService;
    @Autowired
    private EspecialGoodsService especialGoodsService;

    @SysLog("添加商品购物车")
    @RequestMapping(value = "/goods/add/car", method = RequestMethod.GET)
    public R addToCar(GoodsCarEntity entity) {
        Map<String, Object> map = new HashMap<>();
        map.put("user_id", entity.getUserId());
        map.put("goods_id", entity.getGoodsId());
        List<GoodsCarEntity> list = goodsCarService.selectByMap(map);
        if (null != list && list.size() > 0) {
            GoodsCarEntity goodsCarEntity = new GoodsCarEntity();
            goodsCarEntity.setId(list.get(0).getId());
            goodsCarEntity.setCreateTime(new Date());
            goodsCarEntity.setGoodsId(entity.getGoodsId());
            goodsCarEntity.setUserId(entity.getUserId());
            goodsCarEntity.setNum(list.get(0).getNum() + 1);
            goodsCarService.updateById(goodsCarEntity);
        } else {
            entity.setNum(1);
            goodsCarService.insert(entity);
        }
        return R.ok();
    }

    @SysLog("减少购物车商品数量")
    @RequestMapping(value = "/goods/reduce/car", method = RequestMethod.GET)
    public R reduceToCar(GoodsCarEntity entity) {
        if (entity.getNum() == 0) {
            goodsCarService.deleteById(entity.getId());
        } else {
            goodsCarService.updateById(entity);
        }
        return R.ok();
    }

    @SysLog("删除购物车商品")
    @RequestMapping(value = "/goods/delete/car", method = RequestMethod.GET)
    public R deleteFromCar(GoodsCarEntity entity) {
        goodsCarService.deleteById(entity.getId());
        return R.ok();
    }

    /**
     * 获取购物车列表
     * @param userId 当前登录用户
     * @return 返回购物车列表
     */
    @RequestMapping(value = "/goods/car/list", method = RequestMethod.GET)
    public R getCarList(int userId) {
        List<CarListForm> resultList = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("user_id", userId);
        List<GoodsCarEntity> carList = goodsCarService.selectByMap(map);
        for (GoodsCarEntity entity : carList) {
            EspecialGoodsEntity especialGoodsEntity = especialGoodsService.selectById(entity.getGoodsId());
            CarListForm carListForm = new CarListForm();
            carListForm.setNum(entity.getNum());
            carListForm.setId(entity.getId());
            carListForm.setGoodsId(entity.getGoodsId());
            carListForm.setContent(especialGoodsEntity.getContent());
            carListForm.setTitle(especialGoodsEntity.getTitle());
            carListForm.setImgUrl(especialGoodsEntity.getImgUrl());
            carListForm.setRealPrice(especialGoodsEntity.getRealPrice());
            resultList.add(carListForm);
        }
        return R.ok().put("data", resultList);
    }
}
