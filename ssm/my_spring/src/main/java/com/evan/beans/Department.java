// AUTHOR: CSR丶SUSE
// TIME : 2022-02-01  0:10
// FILENAME: Department.java
// TOOLS : INTELLIJ IDEA
// STATEMENT: 


package com.evan.beans;

import lombok.Setter;

public class Department {
    @Setter
    private String dname;

    @Override
    public String toString() {
        return "Department{" +
                "dname='" + dname + '\'' +
                '}';
    }
}
