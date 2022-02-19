// Author : evan lee
// Time ： 2022-02-19  14:07
// FILENAME : PropertiesTest.java
// STATEMENT: 

package com.evan;


import com.evan.config.MessageConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import javax.annotation.Resource;

@SpringBootTest()
@Import(MessageConfig.class)
public class TempBeanTest {

    @Resource
    private String msg;

    @Test
    void testProperties() {
        System.out.println(msg);
    }
}
