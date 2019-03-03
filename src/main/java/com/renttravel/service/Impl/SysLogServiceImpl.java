package com.renttravel.service.Impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.renttravel.dao.SysLogDao;
import com.renttravel.entity.SysLogEntity;
import com.renttravel.service.SysLogService;
import org.springframework.stereotype.Service;

/**
 * 日志信息
 * created by nicking
 * data: 2019/2/27
 * time: 15:47
 */
@Service("SysLogService")
public class SysLogServiceImpl extends ServiceImpl<SysLogDao, SysLogEntity> implements SysLogService {
}
