// AUTHOR: CSR丶SUSE
// TIME : 2022-01-31  23:54
// FILENAME: UserService.java
// TOOLS : INTELLIJ IDEA
// STATEMENT: 


package com.evan.service;

import com.evan.dao.UserDao;
import lombok.Setter;

public class UserService {
    @Setter
    private UserDao userDao;

    public void addUser() {
        userDao.addUser(null);
    }
}
