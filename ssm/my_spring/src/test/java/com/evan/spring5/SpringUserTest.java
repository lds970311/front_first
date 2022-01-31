// AUTHOR: CSR丶SUSE
// TIME : 2022-01-31  14:01
// FILENAME: SpringUserTest.java
// TOOLS : INTELLIJ IDEA
// STATEMENT: 


package com.evan.spring5;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringUserTest {
    public static Logger logger = LoggerFactory.getLogger(SpringUserTest.class);

    @Test
    public void userTest() {
        //加载Spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/beans.xml");
        //获取配置的对象
        User user = context.getBean("user", User.class);
        user.add();
        logger.info("123");
    }
}
