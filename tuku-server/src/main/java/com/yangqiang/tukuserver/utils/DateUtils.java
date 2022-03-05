package com.yangqiang.tukuserver.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {


    /**
     * 获取当前时间
     * @return
     */
    public static String getCurrentDate(){
        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime currentDate = LocalDateTime.now();
        return dateTimeFormatter.format(currentDate);
    }

}
