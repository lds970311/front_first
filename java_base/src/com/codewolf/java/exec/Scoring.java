// Author : evan lee
// Time ： 2022-01-02  0:55
// FILENAME : Scoring.java

/*
在编程竞赛中，有6个评委为参赛的选手打分，分数为0-100的整数分。   选手的最后得分为：去掉一个最高分和一
个最低分后 的4个评委平均值
 */

package com.codewolf.java.exec;

import java.util.Scanner;

public class Scoring {
    public static double getScore() {
        Scanner scanner = new Scanner(System.in);
        int[] scores = new int[6];
        for (int i = 1; i <= 6; i++) {
            System.out.printf("输入第%d个分数\n", i);
            scores[i - 1] = scanner.nextInt();
        }
        int min = scores[0];
        int max = scores[0];
        for (int score : scores) {
            if (score < min) min = score;
            if (score > max) max = score;
        }
        double total = 0;
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == min || scores[i] == max) {
                continue;
            }
            total += scores[i];
        }
        System.out.println(total);
        return total / (scores.length - 2);
    }

    public static void main(String[] args) {
        double score = getScore();
        System.out.println(score);
    }
}
