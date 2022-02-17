// Author : evan lee
// Time ： 2022-02-16  0:20
// FILENAME : Book.java
// STATEMENT: 

package com.evan.boot_ssmp.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("book")
public class Book {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String title;
    private String author;
    private Double price;
    private Integer sales;
    private Integer stock;
    private String imgPath;
}
