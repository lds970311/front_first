// Author : evan lee
// Time ： 2022-01-21  14:01
// FILENAME : Book.java
// STATEMENT: 

package com.evan.web.beans;

import lombok.Data;

@Data
public class Book {
    private String name;
    private Double price;
    private String category;

    public Book() {
    }

    public Book(String name, Double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
}
