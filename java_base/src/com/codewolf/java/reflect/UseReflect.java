// Author : evan lee
// Time ： 2022-01-09  18:30
// FILENAME : UseReflect.java

//需求：给你任意一个对象，在不清楚对象字段的情况可以，可以把对象的字段名称和对应值存储到文件中去。

package com.codewolf.java.reflect;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;

public class UseReflect {
    public static void writeFieldsToFile(Object obj) {
        Class<?> cls = obj.getClass();
        Field[] fields = cls.getDeclaredFields();
        File file = new File("F:\\Java\\front_first\\java_base\\logs\\object.txt");
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
            for (Field field : fields) {
                String type = field.getType().toString();
                String name = field.getName();
                byte[] buf = (type + " : " + name + "\n").getBytes();
                randomAccessFile.write(buf, 0, buf.length);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        TestCls cls = new TestCls("lucy", 21);
        writeFieldsToFile(cls);
    }
}
