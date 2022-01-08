// Author : evan lee
// Time ： 2022-01-08  15:24
// FILENAME : ThreadPools.java
// STATEMENT: 线程池

package com.codewolf.java.threads;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.concurrent.*;

class RunnableA implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + "输出了：HelloWorld ==> " + i);
        }
    }
}

class CallableA implements Callable<Integer> {
    private int val;

    public CallableA(int val) {
        this.val = val;
        try {
            PrintStream ps = new PrintStream("F:\\Java\\front_first\\java_base\\logs\\threadpool.log");
            System.setOut(ps);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Integer call() throws Exception {
        int res = 0;
        for (int i = 0; i < val; i++) {
            System.out.println(Thread.currentThread().getName() + "res = " + res);
            Thread.sleep(80);
            res += i;
        }
        return res;
    }
}

public class ThreadPools {
    @Test
    public void call() throws ExecutionException, InterruptedException {
        ExecutorService pool = new ThreadPoolExecutor(3, 10, 6, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(5),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());
        CallableA callableA = new CallableA(100);
        CallableA callableB = new CallableA(1000);
        CallableA callableC = new CallableA(200);
        CallableA callableD = new CallableA(140);
        Future<Integer> submit = pool.submit(callableA);
        Future<Integer> submit1 = pool.submit(callableB);
        Future<Integer> submit2 = pool.submit(callableC);
        Future<Integer> submit3 = pool.submit(callableD);
        System.out.println(submit.get());
        System.out.println(submit1.get());
        System.out.println(submit2.get());
        System.out.println(submit3.get());
    }

    public static void main(String[] args) {
        ExecutorService pool = new ThreadPoolExecutor(2, 5, 6, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(5),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        //给任务处理
        Runnable a = new RunnableA();
        pool.execute(a);
        pool.execute(a);
        pool.execute(a);

    }
}
