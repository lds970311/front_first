// AUTHOR: CSR丶SUSE
// TIME : 2022-01-31  23:55
// FILENAME: UserDaoImpl.java
// TOOLS : INTELLIJ IDEA
// STATEMENT: 


package com.evan.dao;

import com.evan.domain.Student;

public class UserDaoImpl implements UserDao {
    @Override
    public void addUser(Student student) {
        System.out.println("impl add student");
    }
}
