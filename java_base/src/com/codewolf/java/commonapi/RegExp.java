// Author : evan lee
// Time ： 2022-01-04  21:27
// FILENAME : RegExp.java
// STATEMENT: 

package com.codewolf.java.commonapi;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp {
    public static boolean isQQ(String qq) {
        return qq != null && qq.matches("\\d{6,15}");
    }

    @Test
    public void qqTest() {
        boolean qq = isQQ("24551221");
        System.out.println(qq);
    }

    @Test
    public void scraw() {
        String rs = "来黑马程序学习Java,电话020-43422424，或者联系邮箱itcast@itcast.cn,电话18762832633，0203232323邮箱bozai@itcast.cn，400-100-3233 ，4001003232";
        String regex = "(\\w{1,}@\\w{2,10}(\\.\\w{2,10}){1,2})|(1[3-9]\\d{9})|(0\\d{2,5}-?\\d{5,15})|400-?\\d{3,8}-?\\d{3,8}";
        //2.编译正则表达式成为一个匹配规则对
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(rs);
        // 4.通过匹配器去内容中爬取出信

        while (matcher.find()) {
            System.out.println(matcher.group());
        }

    }
}
