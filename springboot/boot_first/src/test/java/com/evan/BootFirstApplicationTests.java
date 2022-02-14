package com.evan;

import com.evan.dao.UserDao;
import com.evan.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BootFirstApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    void contextLoads() {
        System.out.println("Hello springboot");
    }

    @Test
    public void getUserTest() {
        User user = userDao.getUserById(1);
        System.out.println(user);
    }
}
