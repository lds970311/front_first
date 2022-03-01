// Author : evan lee
// Time ： 2022-02-28  23:02
// FILENAME : DaoTest.java
// STATEMENT: 

package com.evanlee.note;

import com.evan.note.dao.iml.UserDaoImpl;
import com.evan.note.pojo.User;
import org.junit.jupiter.api.Test;

public class DaoTest {
    @Test
    void testGetUserByName() {
        UserDaoImpl userDao = new UserDaoImpl();
        User admin = userDao.getUserByName("admin");
        System.out.println(admin);
    }
}
