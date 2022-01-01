package com.codewolf.java.scanner;

// Author : CSR丶SUSE
// Time ： 2022-01-01  0:58
// TOOLS : INTELLIJ IDEA
// FILENAME : DaysCalculator.java
// STATEMENT: 


import java.util.Scanner;

public class DaysCalculator {

    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("年份?");
        short year = scanner.nextShort();
        System.out.println("月份?");
        byte month = scanner.nextByte();
        System.out.println("几号?");
        byte day = scanner.nextByte();
        int total = 0;
        switch (month) {
            case 12:
                total += 30;
            case 11:
                total += 31;
            case 10:
                total += 30;
            case 9:
                total += 31;
            case 8:
                total += 31;
            case 7:
                total += 30;
            case 6:
                total += 31;
            case 5:
                total += 30;
            case 4:
                total += 31;
            case 3:
                if (isLeapYear(year)) {
                    total += 29;
                } else {
                    total += 28;
                }
            case 2:
                total += 31;
            case 1:
                break;
            default:
                System.out.println("输入的月份有误!");
        }
        int all = total + day;
        System.out.printf("当前的第%d天", all);
    }
}
