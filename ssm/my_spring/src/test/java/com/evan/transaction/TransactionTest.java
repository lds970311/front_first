// Author : evan lee
// Time ： 2022-02-04  11:42
// FILENAME : TransactionTest.java
// STATEMENT: 

package com.evan.transaction;

import com.evan.transaction.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TransactionTest {

    @Test
    public void transactionTest() {
        Object object;
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService = context.getBean("accountService", AccountService.class);
        accountService.accountMoney();
    }
}
