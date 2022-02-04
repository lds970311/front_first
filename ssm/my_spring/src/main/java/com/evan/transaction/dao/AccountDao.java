// Author : evan lee
// Time ： 2022-02-04  12:19
// FILENAME : AccountDao.java
// STATEMENT: 

package com.evan.transaction.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface AccountDao {
    void reduceMoney();

    void addMoney();
}
