// Author : evan lee
// Time ： 2022-01-21  18:47
// FILENAME : User.java
// STATEMENT: 

package com.codewolf.domain;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String name;
    private String gender;
    private String address;
    private String qq;
    private Integer age;
    private String email;

    public User() {
    }

    public User(Integer id, String name, String gender, String address, String qq, String email, Integer age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.qq = qq;
        this.age = age;
        this.email = email;
    }
}
