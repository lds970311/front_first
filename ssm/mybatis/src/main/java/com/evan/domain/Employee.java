// Author : evan lee
// Time ： 2022-01-28  1:53
// FILENAME : Employee.java
// STATEMENT: 

package com.evan.domain;

import lombok.Data;

@Data
public class Employee {
    private int id;
    private String lastName;
    private String gender;
    private String email;

    public Employee(int id, String lastName, String gender, String email) {
        this.id = id;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
    }

    public Employee() {
    }
}
