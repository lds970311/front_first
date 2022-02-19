// Author : evan lee
// Time ： 2022-02-19  14:07
// FILENAME : PropertiesTest.java
// STATEMENT: 

package com.evan;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(args = {
        "--test.info = hehe"
})
public class PropertiesTest {

    @Value("${test.info}")
    private String info;

    @Test
    void testProperties() {
        System.out.println(info);
    }
}
