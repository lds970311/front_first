// Author : evan lee
// Time ： 2022-02-13  23:58
// FILENAME : User.java
// STATEMENT: 

package com.evan.domain;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String name;
    private String password;
    private String address;
    private String phone;

    public User() {
    }

    public User(Integer id, String name, String password, String address, String phone) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.address = address;
        this.phone = phone;
    }
}
