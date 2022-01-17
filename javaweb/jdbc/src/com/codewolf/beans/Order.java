// Author : evan lee
// Time ： 2022-01-17  20:30
// FILENAME : Order.java
// STATEMENT: 

package com.codewolf.beans;

import lombok.Data;

import java.util.Date;

@Data
public class Order {
    private String orderName;
    private Date orderDate;

    public Order() {
    }

    public Order(String orderName, Date orderDate) {
        this.orderName = orderName;
        this.orderDate = orderDate;
    }
}
