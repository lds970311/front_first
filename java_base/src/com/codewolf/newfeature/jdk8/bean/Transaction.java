// Author : evan lee
// Time ： 2022-02-20  19:31
// FILENAME : Transaction.java
// STATEMENT: 

package com.codewolf.newfeature.jdk8.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    private Trader trader;
    private int year;
    private int value;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Trader {
        private String name;
        private String city;
    }
}

