// Author : evan lee
// Time ： 2022-02-10  22:10
// FILENAME : EmployeePlus.java
// STATEMENT: 

package com.evan.domain;

import lombok.Data;

@Data
public class EmployeePlus {
    private int id;
    private String lastName;
    private String gender;
    private String email;
    private Department department;

    public EmployeePlus() {
    }

    public EmployeePlus(int id, String lastName, String gender, String email, Department department) {
        this.id = id;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.department = department;
    }
}
