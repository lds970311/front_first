// AUTHOR: CSR丶SUSE
// TIME : 2022-02-01  21:33
// FILENAME: AnnoTationTest.java
// TOOLS : INTELLIJ IDEA
// STATEMENT: 基于注解管理bean 测试


package com.evan.annotations;

import com.evan.annotation.OrderService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnoTationTest {
    private static final ApplicationContext context;

    static {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void annoService() {
        OrderService orderService = context.getBean("orderService", OrderService.class);
        orderService.addOrder();
        System.out.println(orderService);
    }
}
