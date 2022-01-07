// Author : evan lee
// Time ： 2022-01-07  22:46
// FILENAME : PropertiesTest.java
// STATEMENT: 

package com.codewolf.java.io;

import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {
    @Test
    public void property() throws Exception {
        Properties properties = new Properties();
        properties.setProperty("admin", "123456");
        properties.setProperty("dlei", "003197");
        properties.setProperty("heima", "itcast");
        System.out.println(properties);
        /**
         参数一：保存管道 字符输出流管道
         参数二：保存心得
         */
        properties.store(new FileWriter("F:\\Java\\front_first\\java_base\\testfiles\\props.properties")
                , "");
    }

    @Test
    public void loadProps() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileReader("F:\\Java\\front_first\\java_base\\testfiles\\props.properties"));
        String admin = properties.getProperty("admin");
        String dlei = properties.getProperty("dlei");
        System.out.println(admin);
        System.out.println(dlei);
    }
}
