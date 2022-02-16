// Author : evan lee
// Time ： 2022-02-16  0:20
// FILENAME : Book.java
// STATEMENT: 

package com.evan.boot_ssmp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private Integer id;
    private String title;
    private String author;
    private Double price;
    private Integer sales;
    private Integer stock;
    private String imgPath;
}
