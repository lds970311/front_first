// AUTHOR: CSR丶SUSE
// TIME : 2022-02-01  11:25
// FILENAME: CollectionTest.java
// TOOLS : INTELLIJ IDEA
// STATEMENT: 


package com.evan.spring5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CollectionTest {
    private static final ApplicationContext context;

    static {
        context = new ClassPathXmlApplicationContext("spring/beans2.xml");
    }
}

