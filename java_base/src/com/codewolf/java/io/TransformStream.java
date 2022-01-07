// Author : evan lee
// Time ： 2022-01-07  20:44
// FILENAME : TransformStream.java
// STATEMENT: 转化流 InputStreamReader/OutputStreamWriter

package com.codewolf.java.io;

import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class TransformStream {
    @Test
    public void transformEncode() throws IOException {
        //读取utf-8文件,以gbk写出
        InputStream inStream = new FileInputStream("F:\\Java\\front_first\\java_base\\src\\com\\codewolf\\java\\io\\exec\\csb_res.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(inStream, StandardCharsets.UTF_8);
        //定义输出转化流
        OutputStream oStream = new FileOutputStream("F:\\Java\\front_first\\java_base\\src\\com\\codewolf\\java\\io\\exec\\csb_gbk.txt");
        OutputStreamWriter ow = new OutputStreamWriter(oStream, "gb2312");
        char[] buf = new char[32];
        int len;
        while ((len = inputStreamReader.read(buf)) != -1) {
            ow.write(new String(buf, 0, len));
        }
        inputStreamReader.close();
        ow.close();
    }
}
