// Author : evan lee
// Time ： 2022-01-07  19:46
// FILENAME : FileSort.java
// STATEMENT: 拷贝出师表到另一个文件，恢复顺序

package com.codewolf.java.io.exec;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FileSort {
    public static List<String> read() {

        try (
                Reader reader = new FileReader("F:\\Java\\front_first\\java_base\\src\\com\\codewolf\\java\\io\\exec\\csb.txt");
                BufferedReader br = new BufferedReader(reader);
        ) {
            List<String> results = new ArrayList<>();
            String content;
            while ((content = br.readLine()) != null) {
                results.add(content);
            }
            return results;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        List<String> read = read();
        assert read != null;
        sort(read);
        write(read);
    }

    /**
     * 写入新文件
     *
     * @param read
     */
    private static void write(List<String> read) {
        System.out.println(read);
        Writer writer = null;
        BufferedWriter bw = null;
        try {
            writer = new FileWriter("F:\\Java\\front_first\\java_base\\src\\com\\codewolf\\java\\io\\exec\\csb_res.txt");
            bw = new BufferedWriter(writer);
            for (String s : read) {
                bw.write(s);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void sort(List<String> read) {
        // 4、排序
        // 自定义排序规则
        List<String> sizes = new ArrayList<>();
        Collections.addAll(sizes, "一", "二", "三", "四", "五", "陆", "柒", "八", "九", "十", "十一");

        read.sort(Comparator.comparingInt(o -> sizes.indexOf(o.substring(0, o.indexOf(".")))));
    }
}
