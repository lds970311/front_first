// AUTHOR: CSR丶SUSE
// TIME : 2022-02-01  23:19
// FILENAME: CartDaoImpl.java
// TOOLS : INTELLIJ IDEA
// STATEMENT: 


package com.evan.aop.impl;

import com.evan.aop.dao.CartDao;

public class CartDaoImpl implements CartDao {
    @Override
    public int addCart(int a, int b) {
        return a + b;
    }

    @Override
    public String update(String id) {
        return id + "has updated!";
    }
}
