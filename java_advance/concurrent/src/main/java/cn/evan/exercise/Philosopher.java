// Author : evan lee
// Time ： 2022-07-26  18:23
// FILENAME : Philosopher.java
// STATEMENT: 哲学家就餐问题(死锁)

package cn.evan.exercise;

import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

@Slf4j(topic = "c.Philosopher")
public class Philosopher extends Thread {

    private Chopstick left;
    private Chopstick right;

    public Philosopher(String name, Chopstick left, Chopstick right) {
        super(name);
        this.left = left;
        this.right = right;
    }

    public static void main(String[] args) {
        //就餐
        Chopstick c1 = new Chopstick("1");
        Chopstick c2 = new Chopstick("2");
        Chopstick c3 = new Chopstick("3");
        Chopstick c4 = new Chopstick("4");
        Chopstick c5 = new Chopstick("5");
        new Philosopher("苏格拉底", c1, c2).start();
        new Philosopher("柏拉图", c2, c3).start();
        new Philosopher("亚里士多德", c3, c4).start();
        new Philosopher("赫拉克利特", c4, c5).start();
        new Philosopher("阿基米德", c5, c1).start();
    }

    private void eat() {
        log.debug("eating...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        while (true) {
            // 获得左手筷子
            if (left.tryLock()) {
                try {
                    //获得右手筷子
                    if (right.tryLock()) {
                        try {
                            this.eat();
                        } finally {
                            // 放下右手筷子
                            right.unlock();
                        }
                    }
                } finally {
                    // 放下左手筷子
                    left.unlock();
                }
            }

        }
    }
}


@AllArgsConstructor
@ToString
class Chopstick extends ReentrantLock {
    String name;
}