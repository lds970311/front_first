// Author : evan lee
// Time ： 2022-01-02  20:56
// FILENAME : StringAPI.java
// STATEMENT: 

package com.codewolf.java.commonapi;

import org.junit.Test;

import java.util.Scanner;

public class StringAPI {
    @Test
    public void test1() {
        String abc = new String("abc");
        char[] ch = {'A', 'B', 'C'};
        byte[] bytes = {56, 87, 45};
        String s = new String(ch);
        String s1 = new String(bytes);
        String s2 = "abc";
        System.out.println(abc == s2);
        System.out.println(s == s1);
    }

    /**
     * 遍历字符串
     */
    public static void traverse() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input a string");
        String s = scanner.nextLine();
        for (int i = 0; i < s.length(); i++) {
            System.out.print(s.charAt(i) + " ");
        }
    }

    /**
     * 键盘录入一个字符串，统计该字符串中大写字母字符，小写字母字符，数字字符出现的次数(不考虑其他字符)
     */
    public static void charCount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input a string");
        String line = scanner.nextLine();
        int cap = 0;
        int low = 0;
        int num = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) >= 'A' && line.charAt(i) <= 'Z') {
                cap++;
            } else if (line.charAt(i) >= 'a' && line.charAt(i) <= 'z') {
                low++;
            } else if (line.charAt(i) >= '0' && line.charAt(i) <= '9') {
                num++;
            }
        }
        System.out.printf("大写字母%d次 小写字母%d次 数字%d次\n", cap, low, num);
        //HELLO my frined 123
        //大写字母5次 小写字母8次 数字3次
    }

    public static String reverse() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input a string");
        String line = scanner.nextLine();
        return new StringBuilder(line).reverse().toString();
    }

    public static void main(String[] args) {
        //charCount();
        System.out.println(reverse());
    }
}
