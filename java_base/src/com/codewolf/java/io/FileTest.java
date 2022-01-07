// Author : evan lee
// Time ： 2022-01-06  22:06
// FILENAME : FileTest.java
// STATEMENT: 

package com.codewolf.java.io;

import org.junit.Test;

import java.io.File;

public class FileTest {
    @Test
    public void files() {
        File file = new File("F:\\Java\\front_first\\java_base\\logs\\error.log");
        System.out.println(file.getAbsolutePath());
        long size = file.length();
        System.out.println(size);
    }

    @Test
    public void traversalFiles() {
        File out = new File("F:\\Java\\front_first\\out");
        getAllFiles(out);
    }

    public static void getAllFiles(File file) {

        System.out.println(file.getAbsolutePath());

        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File file1 : files) {
                if (file1.isDirectory()) {
                    getAllFiles(file1);
                }
            }
        }
    }
}
