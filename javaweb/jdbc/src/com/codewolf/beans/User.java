// Author : evan lee
// Time ： 2022-01-17  10:55
// FILENAME : User.java
// STATEMENT: 

package com.codewolf.beans;

import lombok.Data;

@Data
public class User {
    private String name;
    private String password;
    private String address;
    private String phone;

    public User() {
    }

    public User(String name, String password, String address, String phone) {
        this.name = name;
        this.password = password;
        this.address = address;
        this.phone = phone;
    }
}
