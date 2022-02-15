// Author : evan lee
// Time ： 2022-02-14  22:29
// FILENAME : ActiveRecordTest.java
// STATEMENT: 

package com.evan.mp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.evan.dao.UserMapper;
import com.evan.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class ActiveRecordTest {

    @Resource
    private UserMapper userMapper;

    /**
     * 根据主键查询
     */
    @Test
    public void testAR() {
        User user = new User();
        user.setId(3);
        User user1 = user.selectById();
        System.out.println(user1);
    }

    /**
     * 添加用户
     */
    @Test
    public void addUser() {
        User user = new User(null, "刘德华", 60, "ldh", "HongKong", "443312");
        boolean insert = user.insert();
        if (insert) {
            System.out.println("插入成功");
        }
    }

    /**
     * 更新操作
     */
    @Test
    public void updateUser() {
        User user = new User();
        user.setId(6);
        user.setAge(6);
        user.setAddress("Singarepo");
        boolean b = user.updateById();
        if (b) {
            System.out.println("update success!");
        }
    }

    /**
     * 删除操作
     */
    @Test
    public void deleteUser() {
        User user = new User();
        user.setId(1);
        boolean b = user.deleteById();
        if (b) {
            System.out.println("delete success");
        }
    }

    /**
     * 根据条件查询
     */
    @Test
    public void getUserByCondition() {
        User user = new User();
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("address", "上海")
                .gt("age", 20);
        List<User> users = user.selectList(userQueryWrapper);
        users.forEach(System.out::println);
    }


}
