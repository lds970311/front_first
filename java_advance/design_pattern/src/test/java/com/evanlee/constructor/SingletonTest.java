// Author : evan lee
// Time ： 2022-02-22  1:03
// FILENAME : SingletonTest.java
// STATEMENT: 

package com.evanlee.constructor;

import com.evanlee.principle.openClose.singletonmode.HungrySingleton;
import com.evanlee.principle.openClose.singletonmode.LazySingleton;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class SingletonTest {
    @Test
    void testA() {
        HungrySingleton instance = HungrySingleton.getInstance();
        HungrySingleton instance2 = HungrySingleton.getInstance();
        System.out.println(instance == instance2);
    }

    @Test
    void lazyTest() {
        LazySingleton instance = LazySingleton.getInstance();
        LazySingleton instance2 = LazySingleton.getInstance();
        System.out.println(instance == instance2);
    }

    @Test
    void runtimeTest() throws IOException {
        Runtime runtime = Runtime.getRuntime();
        System.out.println(runtime.availableProcessors());
        System.out.println(runtime.totalMemory());
        Process ipconfig = runtime.exec("ipconfig");
        InputStream inputStream = ipconfig.getInputStream();
        byte[] buffer = new byte[1024 * 10 * 1024];
        int len = inputStream.read(buffer);
        System.out.println(len);
        System.out.println(new String(buffer, 0, len, "GBK"));
    }
}
