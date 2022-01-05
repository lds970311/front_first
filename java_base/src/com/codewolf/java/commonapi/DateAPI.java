// Author : evan lee
// Time ： 2022-01-04  1:19
// FILENAME : DateAPI.java
// STATEMENT: 日期时间API

package com.codewolf.java.commonapi;

import com.codewolf.java.exec.DateUtils;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class DateAPI {
    @Test
    public void date() {
        Date date = new Date();
        System.out.println(date);
        System.out.println(date.getTime());
    }

    @Test
    public void dateFormatter() {
        DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
        Date date = new Date();
        String dateStr = dateFormat.format(date);
        System.out.println(dateStr);

        String s = "2021-12-30 11:12:45";
        try {
            Date parse = dateFormat.parse(s);
            System.out.println(parse); //Thu Dec 30 11:12:45 CST 2021
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void dateUtilTest() {
        String s = DateUtils.dateToString(new Date(), "yy-MM-dd HH:mm:ss");
        System.out.println(s);
        try {
            Date date = DateUtils.stringToDate("2025-01-21", "yy-MM-dd");
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void calender() {
        Calendar calendar = Calendar.getInstance(); //多态形式
//        System.out.println(calendar);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_YEAR);
        System.out.printf("%d %d %d\n", year, month, day);
    }

    @Test
    public void localDateTime() {
        LocalDate now = LocalDate.now();
        LocalDate localDate = now.plusDays(20);
        System.out.println(localDate);
    }
}
