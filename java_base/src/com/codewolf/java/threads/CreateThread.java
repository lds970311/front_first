// Author : evan lee
// Time ： 2022-01-07  23:26
// FILENAME : CreateThread.java
// STATEMENT: 创建线程

package com.codewolf.java.threads;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CreateThread {

    static class MyThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println("子线程" + i);
            }
        }
    }

    private static class MyCall implements Callable<String> {
        private int id;

        public MyCall(int id) {
            this.id = id;
        }

        @Override
        public String call() throws Exception {
            int sum = 0;
            for (int i = 1; i <= id; i++) {
                sum += i;
            }
            return "子线程执行的结果是：" + sum;
        }
    }

    @Test
    public void create() {
        Thread myThread = new MyThread();
        myThread.start();
    }

    @Test
    public void futuretask() {
        Callable<String> myCall = new MyCall(10);
        FutureTask<String> task = new FutureTask<>(myCall);
        new Thread(task).start();
        try {
            String result = task.get();
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    @SneakyThrows
    @Test
    public void futuretask2() {
        FutureTask<Integer> task = new FutureTask<>(() -> {
            int all = 0;
            for (int i = 0; i < 100; i++) {
                all += i;
            }
            return all;
        });
        new Thread(task).start();
        System.out.println(task.get());
    }
}
