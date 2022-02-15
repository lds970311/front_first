// Author : evan lee
// Time ： 2022-02-14  17:30
// FILENAME : MapperCRUDTest.java
// STATEMENT: 

package com.evan.mp;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.evan.dao.UserMapper;
import com.evan.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class MapperCRUDTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void getAll() {
        List<User> users = userMapper.selectList(null);
        Wrapper<User> userUpdateWrapper = new UpdateWrapper<>();
        users.forEach(System.out::println);
    }

    @Test
    public void insert() {
        int insert = userMapper.insert(new User(null, "jinx", 23, "111222", "上海", "233"));
        if (insert != 0) {
            System.out.println("insert success!");
        }
    }

    @Test
    public void deleteTest() {
        //根据wrapper删除
        User user = new User();
        user.setAge(21);
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>(user);
        int delete = this.userMapper.delete(userQueryWrapper);
        System.out.println(delete);
    }

    @Test
    public void testSelectBatchIds() { //根据id集合批量查询
        List<User> users = this.userMapper.selectBatchIds(Arrays.asList(2L, 3L, 10L));
        for (User user : users) {
            System.out.println(user);
            //
        }
    }

    @Test
    public void testSelectOne() {
        QueryWrapper<User> wrapper = new QueryWrapper<User>();
        wrapper.eq("name", "汪峰"); //根据条件查询一条数据，如果结果超过一条会报错
        User user = this.userMapper.selectOne(wrapper);
        System.out.println(user);
    }

    @Test
    public void selectPageTest() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        //设置查询条件
        wrapper.gt("id", "5");

        Page<User> page = new Page<>(3, 1); //查询第3页，查询1条数据
        IPage<User> iPage = this.userMapper.selectPage(page, wrapper);
        System.out.println("数据总条数： " + iPage.getTotal());
        System.out.println("数据总页数： " + iPage.getPages());
        System.out.println("当前页数： " + iPage.getCurrent());

        List<User> records = iPage.getRecords();
        for (User record : records) {
            System.out.println(record);
        }
    }

    @Test
    public void findByNameTest() {
        User user = this.userMapper.findByName("汪峰");
        System.out.println(user);
    }
}