// Author : evan lee
// Time ： 2022-07-07  8:54
// FILENAME : InterruptTest.java
// STATEMENT: 

package cn.evan.thread;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.InterruptTest")
public class InterruptTest {
    @SneakyThrows
    public static void main(String[] args) {
        Thread threadA = new Thread(() -> {
            while (true) {
                Thread currentThread = Thread.currentThread();
                boolean interrupted = currentThread.isInterrupted();
                if (interrupted) {
                    log.debug(" 打断状态: {}", interrupted);
                    break;
                }
            }
        }, "threadA");
        threadA.start();
        Thread.sleep(500);
        threadA.interrupt();
    }
}
