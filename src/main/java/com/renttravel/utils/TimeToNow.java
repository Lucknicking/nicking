package com.renttravel.utils;

import java.util.Date;

public class TimeToNow {
    private String result;
    public String getResult(Date date) {
        long secondDate = date.getTime()/1000;
//        时间差为
        long interval = System.currentTimeMillis()/1000 - secondDate;
        if (interval < 60) {
            result = interval + "s";
        } else if (interval < 3600) {
            result = interval / 60 + "min";
        } else if (interval < 86400) {
            result = interval / 3600 + "h";
        } else if (interval < 2592000) {
            result = interval / 86400 + "d";
        } else if (interval < 946080000) {
            result = interval / 2592000 + "m";
        } else {
            result = interval / 946080000 + "y";
        }
        return result;
    }
}
