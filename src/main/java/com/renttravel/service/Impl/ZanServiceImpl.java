package com.renttravel.service.Impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.renttravel.FormEntity.StatNewsCommentsOrZan;
import com.renttravel.dao.ZanDao;
import com.renttravel.entity.ZanEntity;
import com.renttravel.service.ZanService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("ZanService")
public class ZanServiceImpl extends ServiceImpl<ZanDao, ZanEntity> implements ZanService {

    @Override
    public List<StatNewsCommentsOrZan> statNewZan() {
        return baseMapper.totalZan();
    }

    /**
     * 点赞或者取消
     */
    @Override
    public boolean InsertOrDelete(ZanEntity zan) {
        Map<String, Object> paramsMap = new HashMap<>();
        paramsMap.put("user_id", zan.getUserId());
        paramsMap.put("news_id", zan.getNewsId());
        List<ZanEntity> resultList = this.selectByMap(paramsMap);
        if (null != resultList && resultList.size() > 0) {
            this.deleteById(resultList.get(0).getId());
            return false;
        } else {
            this.insert(zan);
            return true;
        }
    }
}
