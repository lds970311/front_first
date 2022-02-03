// AUTHOR: CSR丶SUSE
// TIME : 2022-02-02  23:08
// FILENAME: Book.java
// TOOLS : INTELLIJ IDEA
// STATEMENT: 


package com.evan.jdbcTemplate.domain;

import lombok.Data;

@Data
public class Book {
    private Integer id;
    private String name;
    private String author;

    public Book() {
    }

    public Book(Integer id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }
}
