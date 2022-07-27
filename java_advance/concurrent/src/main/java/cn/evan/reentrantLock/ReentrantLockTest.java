// Author : evan lee
// Time ： 2022-07-26  21:20
// FILENAME : ReentrantLockTest.java
// STATEMENT: 

package cn.evan.reentrantLock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

@Slf4j(topic = "c.ReentrantLockTest")
public class ReentrantLockTest {

    private static ReentrantLock lock = new ReentrantLock();

    public static void method1() {
        lock.lock();
        try {
            log.debug("execute method1");
            method2();
        } finally {
            lock.unlock();
        }
    }

    public static void method2() {
        lock.lock();
        try {
            log.debug("execute method2");
            method3();
        } finally {
            lock.unlock();
        }
    }


    public static void method3() {
        lock.lock();
        try {
            log.debug("execute method3");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        method1();
    }
}
