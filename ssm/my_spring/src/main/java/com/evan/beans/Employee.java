// AUTHOR: CSR丶SUSE
// TIME : 2022-02-01  0:10
// FILENAME: Employee.java
// TOOLS : INTELLIJ IDEA
// STATEMENT: 


package com.evan.beans;

import lombok.Setter;

public class Employee {
    @Setter
    private String ename;
    @Setter
    private String gender;
    //员工属于某一个部门，使用对象形式表示
    @Setter
    private Department dept;

    @Override
    public String toString() {
        return "Employee{" +
                "ename='" + ename + '\'' +
                ", gender='" + gender + '\'' +
                ", dept=" + dept +
                '}';
    }
}
