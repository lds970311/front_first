// Author : evan lee
// Time ： 2022-01-01  22:54
// FILENAME : Rabbit.java
/*
有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，问第二十个月的兔子对数为多少
*/
package com.codewolf.java.exec;

public class Rabbit {
    public static int getCount(int num) {
        if (num <= 2) {
            return 1;
        }
        int first = 1;
        int second = 1;
        int last = 0;
        for (int i = 2; i < num; i++) {
            last = first + second;
            first = second;
            second = last;
        }
        return last;
    }

    public static void main(String[] args) {
        int count = getCount(20); //6765
        System.out.println(count);
    }
}
