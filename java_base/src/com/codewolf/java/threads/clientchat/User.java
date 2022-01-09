// Author : evan lee
// Time ： 2022-01-09  0:55
// FILENAME : User.java
// STATEMENT: 

package com.codewolf.java.threads.clientchat;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String name;

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }


    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + "]";
    }

}
