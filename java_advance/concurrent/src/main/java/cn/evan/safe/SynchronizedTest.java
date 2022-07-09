// Author : evan lee
// Time ： 2022-07-08  9:30
// FILENAME : SynchronizedTest.java
// STATEMENT: 

package cn.evan.safe;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.SynchronizedTest")
public class SynchronizedTest {
    static final Object room = new Object();
    static int counter = 0;

    @SneakyThrows
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                synchronized (room) {
                    counter++;
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                synchronized (room) {
                    counter--;
                }
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        log.debug("counter = {}", counter);
    }
}
