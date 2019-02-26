package com.renttravel.utils;

import java.util.Date;

public class TimeToNow {
    private String result;
    public String getResult(Date date) {
        long secondDate = date.getTime()/1000;
//        时间差为
        long interval = System.currentTimeMillis()/1000 - secondDate;
        if (interval < 60) {
            result = interval + "秒";
        } else if (interval < 3600) {
            result = interval / 60 + "分钟";
        } else if (interval < 86400) {
            result = interval / 3600 + "小时";
        } else if (interval < 2592000) {
            result = interval / 86400 + "天";
        } else if (interval < 946080000) {
            result = interval / 2592000 + "月";
        } else {
            result = interval / 946080000 + "年";
        }
        return result + "前";
    }
}
