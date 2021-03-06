package com.yangqiang.tuku.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    // 字符串转date
    public static Date strToDay(String birthDay) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        try {
            date = simpleDateFormat.parse(birthDay);
        } catch (ParseException e) {
            date = new Date();
        }

        return date;
    }


    // 根据生日计算年龄
    public static int getAge(String birthDay) {

        Date date = strToDay(birthDay);

        Calendar cal = Calendar.getInstance();

        if (cal.before(date)) {
            return 100;
        }
        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH);
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
        cal.setTime(date);

        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH);
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

        int age = yearNow - yearBirth;

        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                if (dayOfMonthNow < dayOfMonthBirth)
                    age--;
            } else {
                age--;
            }
        }

        return age;
    }

    /**
     * 获取当前时间
     * @return
     */
    public static String getCurrentDate(){
        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime currentDate = LocalDateTime.now();
        return dateTimeFormatter.format(currentDate);
    }



}
