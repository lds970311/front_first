package com.codewolf.java.exceptions;

import java.util.Scanner;

class ScoreExceptionTest {

    public static void checkScore(int score) throws ScoreException {
        if (score < 0 || score > 100) {
            throw new ScoreException("分数超出限制!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input a score!");
        int score = scanner.nextInt();
        try {
            checkScore(score);
        } catch (ScoreException e) {
            e.printStackTrace();
        }
    }
}