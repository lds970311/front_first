// Author : evan lee
// Time ： 2022-05-13  19:10
// FILENAME : Student.java
// STATEMENT: 

package com.evan.redis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Integer id;
    private String name;
    private String cls;
    private Integer age;
}
