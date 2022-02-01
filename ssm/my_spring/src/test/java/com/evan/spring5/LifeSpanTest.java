// AUTHOR: CSR丶SUSE
// TIME : 2022-02-01  17:07
// FILENAME: LifeSpanTest.java
// TOOLS : INTELLIJ IDEA
// STATEMENT: 


package com.evan.spring5;

import com.evan.lifespan.LifeSpan;
import com.evan.lifespan.MyPostBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifeSpanTest {
    @Test
    public void testA() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/beans3.xml");
        LifeSpan lifespan = context.getBean("lifespan", LifeSpan.class);
        ClassPathXmlApplicationContext context1 = (ClassPathXmlApplicationContext) context;
        //手动销毁bean
        context1.close();
    }

    @Test
    public void postTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/beans3.xml");
        MyPostBean lifespan = context.getBean("mypostbean", MyPostBean.class);
        System.out.println(lifespan);
    }
}
