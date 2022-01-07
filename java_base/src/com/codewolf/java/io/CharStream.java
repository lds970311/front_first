// Author : evan lee
// Time ： 2022-01-07  18:25
// FILENAME : CharStream.java
// STATEMENT: 字节流

package com.codewolf.java.io;

import org.junit.Test;

import java.io.*;

public class CharStream {

    @Test
    public void reader() {
        try {
            Reader reader = new FileReader("F:\\Java\\front_first\\java_base\\testfiles\\mydoc.txt");
            char[] buf = new char[16];
            int len;
            while ((len = reader.read(buf)) != -1) {
                System.out.println(new String(buf, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void writer() {
        try (
                Writer writer = new FileWriter("F:\\Java\\front_first\\java_base\\testfiles\\mydoc.txt", true);
        ) {
            writer.write("today\n");
            writer.write('c');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
