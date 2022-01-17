// Author : evan lee
// Time ： 2022-01-17  18:58
// FILENAME : Customer.java
// STATEMENT: 

package com.codewolf.beans;

import lombok.Data;

import java.util.Date;

@Data
public class Customer {
    private Integer id;
    private String name;
    private String email;
    private Date birth;

    public Customer() {
    }

    public Customer(Integer id, String name, String email, Date birth) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birth = birth;
    }
}
