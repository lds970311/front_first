// Author : evan lee
// Time ： 2022-01-08  18:58
// FILENAME : TimerTest.java
// STATEMENT: 定时器

package com.codewolf.java.threads;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimerTest {

    public static void timer() {
        //创建Timer
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "执行一次");
            }
        }, 1000, 2000);
    }

    public static void schedule() {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(3);
        pool.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "执行一次");
            }
        }, 1, 2, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
        //timer();
        schedule();
    }
}
