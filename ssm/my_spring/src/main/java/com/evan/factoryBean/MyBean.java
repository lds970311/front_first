// AUTHOR: CSR丶SUSE
// TIME : 2022-02-01  11:40
// FILENAME: MyBean.java
// TOOLS : INTELLIJ IDEA
// STATEMENT: 


package com.evan.factoryBean;

import org.springframework.beans.factory.FactoryBean;

public class MyBean implements FactoryBean {
    @Override
    //定义返回bean
    public Object getObject() throws Exception {
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}
