package com.evan;

import com.evan.dao.UserMapper;
import com.evan.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
class ApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
    }

    @Test
    public void userTest() {
        List<User> users = userMapper.selectList(null);
        users.forEach(user -> log.info(user.toString()));
    }

}
