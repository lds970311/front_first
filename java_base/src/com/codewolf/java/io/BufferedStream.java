// Author : evan lee
// Time ： 2022-01-07  19:02
// FILENAME : BufferedStream.java
// STATEMENT: 

package com.codewolf.java.io;

import org.junit.jupiter.api.Test;

import java.io.*;

public class BufferedStream {
    @Test
    public void bufferedInput() {
        try (
                InputStream is = new FileInputStream("F:\\Java\\front_first\\java_base\\testfiles\\mydoc.txt");
                InputStream inputStream = new BufferedInputStream(is); //包装成缓冲流
                OutputStream outputStream = new BufferedOutputStream(new FileOutputStream("F:\\Java\\front_first\\java_base\\testfiles\\mydoc4.txt"));
        ) {
            byte[] buffer = new byte[16];
            int len;
            while ((len = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void bufferedReader() {
        try (
                Reader reader = new FileReader("F:\\Java\\front_first\\java_base\\testfiles\\mydoc.txt");
                BufferedReader br = new BufferedReader(reader);
        ) {
            String line;
            //BufferedReader可以按照行读取!
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
