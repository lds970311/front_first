// Author : evan lee
// Time ： 2022-01-08  15:42
// FILENAME : ThreadCommunication.java
// STATEMENT: 线程通信

/*
要求两个线程，同时打印字母，每个线程都能连续打印3个字母。两个线程交替打印，一个线程打印字母的小写形式，
一个线程打印字母的大写形式，但是字母是连续的。当字母循环到z之后，回到a。
 */

package com.codewolf.java.threads;

class LetterPrinter {
    private static char letter = 'A';

    public synchronized void printLower() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + (char) (letter + 32));
            letter++;
            if (letter > 'Z') {
                letter = 'A';
            }
        }
        this.notifyAll();
        //等待唤醒其他线程
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void printUpper() {
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + (char) letter);
            letter++;
            if (letter > 'Z') {
                letter = 'A';
            }
        }
        //等待唤醒其他线程
        this.notifyAll();
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ThreadCommunication {
    public static void main(String[] args) {
        LetterPrinter letterPrinter = new LetterPrinter();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    letterPrinter.printLower();
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    letterPrinter.printUpper();
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
