// Author : evan lee
// Time ： 2022-01-04  19:03
// FILENAME : DateUtils.java
// STATEMENT: 日期工具类

package com.codewolf.java.exec;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateUtils {

    private DateUtils() {
    }

    public static String dateToString(Date date, String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }

    public static Date stringToDate(String date, String pattern) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.parse(date);
    }
}
