// Author : evan lee
// Time ： 2022-02-14  12:52
// FILENAME : User.java
// STATEMENT: 

package com.evan.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String name;
    private Integer age;
    private String password;
    private String address;
    private String phone;
}
