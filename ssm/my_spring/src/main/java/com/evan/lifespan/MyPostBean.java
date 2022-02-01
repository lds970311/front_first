// AUTHOR: CSR丶SUSE
// TIME : 2022-02-01  17:32
// FILENAME: MyPostBean.java
// TOOLS : INTELLIJ IDEA
// STATEMENT: 


package com.evan.lifespan;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyPostBean implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("在初始化之前执行的方法");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("在初始化之后执行的方法");
        return bean;
    }
}
