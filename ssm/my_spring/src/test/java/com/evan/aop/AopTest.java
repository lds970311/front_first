// AUTHOR: CSR丶SUSE
// TIME : 2022-02-02  21:26
// FILENAME: AopTest.java
// TOOLS : INTELLIJ IDEA
// STATEMENT: 


package com.evan.aop;

import com.evan.aop.aspectj.MyUser;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {


    @Test
    public void aopTestAno() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        MyUser myUser = context.getBean("myUser", MyUser.class);
        myUser.add();
    }
}
