// Author : evan lee
// Time ： 2022-01-04  1:19
// FILENAME : DateAPI.java
// STATEMENT: 日期时间API

package com.codewolf.java.commonapi;

import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
    }
}
