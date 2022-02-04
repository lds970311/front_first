// Author : evan lee
// Time ： 2022-02-04  12:19
// FILENAME : AccountService.java
// STATEMENT: 

package com.evan.transaction.service;

import com.evan.transaction.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED,
        isolation = Isolation.READ_COMMITTED,
        timeout = 5,
        readOnly = false)
public class AccountService {
    @Autowired
    private AccountDao accountDao;

    //转账的方法
    public void accountMoney() {
        //lucy 少 100
        accountDao.reduceMoney();
        int i = 1 / 0;
        //mary 多 100
        accountDao.addMoney();
    }
}
