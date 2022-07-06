// Author : evan lee
// Time ： 2022-07-06  8:25
// FILENAME : FrameTest.java
// STATEMENT: 

package cn.evan.thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FrameTest {
    public static void main(String[] args) {
        method1(11);
        log.debug("end");
    }

    public static void method1(int x) {
        int y = x + 5;
        method2();
    }

    public static Object method2() {
        Object o = new Object();
        return 0;
    }
}
