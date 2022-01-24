// Author : evan lee
// Time ： 2022-01-23  20:31
// FILENAME : Man.java
// STATEMENT: 

package com.evan.proxy;

import lombok.Getter;
import lombok.Setter;

public class Man implements Ticket {
    @Getter
    @Setter
    private String name;

    public Man(String name) {
        this.name = name;
    }


    @Override
    public String buyTicket() {
        System.out.printf("%s, buy ticket\n", this.name);
        return "hello";
    }
}
