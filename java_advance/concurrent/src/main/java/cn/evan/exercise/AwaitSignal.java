// Author : evan lee
// Time ： 2022-07-27  20:43
// FILENAME : AwaitSignal.java
// STATEMENT: 

package cn.evan.exercise;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j(topic = "c.AwaitSignal")
public class AwaitSignal extends ReentrantLock {
    // 循环次数
    private int loopNumber;

    public AwaitSignal(int loopNumber) {
        this.loopNumber = loopNumber;
    }

    public static void main(String[] args) {
        AwaitSignal as = new AwaitSignal(5);
        Condition aWaitSet = as.newCondition();
        Condition bWaitSet = as.newCondition();
        Condition cWaitSet = as.newCondition();
        new Thread(() -> {
            as.print("a", aWaitSet, bWaitSet);
        }).start();
        new Thread(() -> {
            as.print("b", bWaitSet, cWaitSet);
        }).start();
        new Thread(() -> {
            as.print("c", cWaitSet, aWaitSet);
        }).start();
        as.start(aWaitSet);
    }

    public void start(Condition first) {
        this.lock();
        try {
            log.debug("start");
            first.signal();
        } finally {
            this.unlock();
        }
    }

    public void print(String str, Condition current, Condition next) {
        for (int i = 0; i < loopNumber; i++) {
            this.lock();
            try {
                current.await();
                log.debug(str);
                next.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                this.unlock();
            }
        }
    }
}
