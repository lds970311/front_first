// AUTHOR: CSR丶SUSE
// TIME : 2022-02-01  21:29
// FILENAME: OrderService.java
// TOOLS : INTELLIJ IDEA
// STATEMENT: 


package com.evan.annotation;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@ToString
public class OrderService {
    @Autowired
    @Qualifier(value = "orderDaoImpl")
    private OrderDao orderDao;

    @Value("cpu")
    private String orderName;

    public void addOrder() {
        orderDao.addOrder();
    }
}
