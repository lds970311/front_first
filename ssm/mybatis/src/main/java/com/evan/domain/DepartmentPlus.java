// Author : evan lee
// Time ： 2022-02-10  23:41
// FILENAME : DepartmentPlus.java
// STATEMENT: 

package com.evan.domain;

import lombok.Data;

import java.util.List;

@Data
public class DepartmentPlus {
    private Integer id;
    private String deptName;
    private List<EmployeePlus> employeeList;

    public DepartmentPlus() {
    }

    public DepartmentPlus(Integer id, String deptName, List<EmployeePlus> employeeList) {
        this.id = id;
        this.deptName = deptName;
        this.employeeList = employeeList;
    }
}
