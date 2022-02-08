// AUTHOR: CSR丶SUSE
// TIME : 2022-02-06  23:21
// FILENAME: Employee.java
// TOOLS : INTELLIJ IDEA
// STATEMENT: 


package com.evan.mvc.domain;

import lombok.Data;

@Data
public class Employee {
    private Integer id;
    private String lastName;

    private String email;
    //1 male, 0 female
    private Integer gender;

    public Employee() {
    }

    public Employee(Integer id, String lastName, String email, Integer gender) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
    }
}
