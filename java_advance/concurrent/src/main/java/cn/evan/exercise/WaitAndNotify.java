// Author : evan lee
// Time ： 2022-07-18  9:45
// FILENAME : WaitAndNotify.java
// STATEMENT: 

package cn.evan.exercise;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.WaitAndNotify")
public class WaitAndNotify {
    static final Object room = new Object();
    static boolean hasCigarette = false;
    static boolean hasTakeout = false;

    @SneakyThrows
    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (room) {
                log.debug("有烟没？[{}]", hasCigarette);
                if (!hasCigarette) {
                    log.debug("没烟，先歇会！");
                    //Thread.sleep(2000);
                    try {
                        room.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                log.debug("有烟没？[{}]", hasCigarette);
                if (hasCigarette) {
                    log.debug("可以开始干活了");
                } else {
                    log.debug("没干成活...");
                }
            }
        }, "小南").start();

        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                synchronized (room) {
                    log.debug("可以开始干活了");
                }
            }, "其它人").start();
        }

        Thread.sleep(1000);
        new Thread(() -> {
            // 这里能不能加 synchronized (room)？
            synchronized (room) {
                hasCigarette = true;
                log.debug("烟到了噢！");
                room.notifyAll();
            }

        }, "送烟的").start();
    }
}