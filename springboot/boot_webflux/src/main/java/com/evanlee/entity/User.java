// Author : evan lee
// Time ： 2022-02-21  0:14
// FILENAME : User.java
// STATEMENT: 

package com.evanlee.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String name;
    private Integer age;
    private String gender;
}
