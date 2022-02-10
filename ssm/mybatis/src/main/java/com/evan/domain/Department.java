// Author : evan lee
// Time ： 2022-02-10  22:09
// FILENAME : Department.java
// STATEMENT: 

package com.evan.domain;

import lombok.Data;

@Data
public class Department {
    private Integer id;
    private String deptName;

    public Department() {
    }

    public Department(Integer id, String deptName) {
        this.id = id;
        this.deptName = deptName;
    }
}
