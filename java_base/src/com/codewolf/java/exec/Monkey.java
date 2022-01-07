// Author : evan lee
// Time ： 2022-01-06  23:32
// FILENAME : Monkey.java

/*
  猴子第一天摘下若干桃子，当即吃了一半，觉得好不过瘾，于是又多吃了一个
  第二天又吃了前天剩余桃子数量的一半，觉得好不过瘾，于是又多吃了一个
  以后每天都是吃前天剩余桃子数量的一半，觉得好不过瘾，又多吃了一个
  等到第10天的时候发现桃子只有1个了。
  需求：请问猴子第一天摘了多少个桃子？
 */
package com.codewolf.java.exec;

public class Monkey {
    public static int getRes(int n) {
        if (n == 1) return 1;
        return 2 + 2 * getRes(n - 1);
    }

    public static void main(String[] args) {
        int res = getRes(10);
        System.out.println(res);
    }
}
