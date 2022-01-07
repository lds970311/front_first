// Author : evan lee
// Time ： 2022-01-07  22:08
// FILENAME : PrintStream.java
// STATEMENT: 打印流

package com.codewolf.java.io;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class PrintStreamTest {
    @Test
    public void printStream() throws FileNotFoundException {
        PrintStream printStream = new PrintStream("F:\\Java\\front_first\\java_base\\testfiles\\printstream.txt");
        printStream.println(1);
        printStream.println('1');
        printStream.println("hehe");
        printStream.println(true);
        printStream.println(21.5);
        //重定向打印流
        System.setOut(printStream);
        System.out.println("hahaha");
        System.out.println("909090");
    }
}
