// Author : evan lee
// Time ： 2022-07-27  20:36
// FILENAME : SyncWaitNotify.java
// STATEMENT: 

package cn.evan.exercise;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.SyncWaitNotify")
public class SyncWaitNotify {
    /**
     * 线程 1 输出 a 5 次，线程 2 输出 b 5 次，线程 3 输出 c 5 次。现在要求输出 abcabcabcabcabc 怎么实现
     */

    private int flag;//等待标记
    private int loopNumber;

    public SyncWaitNotify(int flag, int loopNumber) {
        this.flag = flag;
        this.loopNumber = loopNumber;
    }

    public static void main(String[] args) {
        SyncWaitNotify syncWaitNotify = new SyncWaitNotify(1, 5);
        new Thread(() -> {
            syncWaitNotify.print(1, 2, "a");
        }).start();
        new Thread(() -> {
            syncWaitNotify.print(2, 3, "b");
        }).start();
        new Thread(() -> {
            syncWaitNotify.print(3, 1, "c");
        }).start();
    }

    public void print(int waitFlag, int nextFlag, String str) {
        for (int i = 0; i < loopNumber; i++) {
            synchronized (this) {
                while (this.flag != waitFlag) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(str);
                this.flag = nextFlag;
                this.notifyAll();
            }
        }
    }
}
