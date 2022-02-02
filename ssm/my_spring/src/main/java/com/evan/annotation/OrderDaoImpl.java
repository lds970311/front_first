// AUTHOR: CSR丶SUSE
// TIME : 2022-02-01  21:29
// FILENAME: OrderDaoImpl.java
// TOOLS : INTELLIJ IDEA
// STATEMENT: 


package com.evan.annotation;

import org.springframework.stereotype.Repository;

@Repository(value = "orderDaoImpl")
public class OrderDaoImpl implements OrderDao {
    @Override
    public void addOrder() {
        System.out.println("order add...");
    }
}
