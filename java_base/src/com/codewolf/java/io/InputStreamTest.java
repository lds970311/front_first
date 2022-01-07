// Author : evan lee
// Time ： 2022-01-07  12:54
// FILENAME : InputStramTest.java
// STATEMENT: 

package com.codewolf.java.io;

import org.junit.Test;

import java.io.*;

public class InputStreamTest {
    @Test
    public void inputStream() {
        try {
            InputStream is = new FileInputStream("F:\\Java\\front_first\\java_base\\testfiles\\mydoc.txt");
            int read = is.read();
            System.out.println(read);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void inputStream2() {
        try {
            InputStream is = new FileInputStream("F:\\Java\\front_first\\java_base\\testfiles\\mydoc.txt");
            byte[] buf = new byte[16];
            int a;
            while ((a = is.read(buf)) != -1) {
                System.out.println(new String(buf, 0, a));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void inputStream3() {
        File file = new File("F:\\Java\\front_first\\java_base\\testfiles\\mydoc.txt");
        byte[] buf = new byte[(int) file.length()];
        try {
            InputStream is = new FileInputStream(file);
            byte[] bytes = is.readAllBytes();
            System.out.println("length:" + bytes.length);
            System.out.println(new String(bytes, 0, bytes.length));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void outputStream() {
        try {
            //源文件追加内容
            OutputStream os = new FileOutputStream("F:\\Java\\front_first\\java_base\\testfiles\\mydoc.txt", true);
            String content = "\nwhat are you ding?";
            byte[] bytes = content.getBytes();
            os.write(bytes);
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void copyFile() {
        InputStream is = null;
        OutputStream outputStream = null;
        try {
            is = new FileInputStream("F:\\Java\\front_first\\java_base\\testfiles\\mydoc.txt");
            outputStream = new FileOutputStream("F:\\Java\\front_first\\java_base\\testfiles\\mydoc1.txt");
            byte[] buf = new byte[32];
            int len;
            while ((len = is.read(buf)) != -1) {
                //写入
                outputStream.write(buf, 0, len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @Test
    //jdk7
    public void copyFile2() {
        try (InputStream is = new FileInputStream("F:\\Java\\front_first\\java_base\\testfiles\\mydoc.txt");
             OutputStream outputStream = new FileOutputStream("F:\\Java\\front_first\\java_base\\testfiles\\mydoc2.txt");
        ) {

            byte[] buf = new byte[32];
            int len;
            while ((len = is.read(buf)) != -1) {
                //写入
                outputStream.write(buf, 0, len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
