// Author : evan lee
// Time ： 2022-01-21  18:56
// FILENAME : UserServiceImpl.java
// STATEMENT: 

package com.codewolf.service;

import com.codewolf.dao.UserDao;
import com.codewolf.dao.UserDaoImpl;
import com.codewolf.domain.PageBean;
import com.codewolf.domain.User;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {

    private final UserDao userDao = new UserDaoImpl();

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public void insert(User user) {
        userDao.insert(user);
    }

    @Override
    public void deleteById(String id) {
        userDao.deleteById(id);
    }

    @Override
    public User findUserById(String id) {
        return userDao.findUserById(id);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public PageBean<User> findUserByPage(String currentPage, String rows, Map<String, String[]> condition) {
        PageBean<User> page = new PageBean<>();
        //设置参数
        int current = Integer.parseInt(currentPage);
        int rowCount = Integer.parseInt(rows);
        if (current < 1) {
            current = 1;
        }

        if (rowCount < 1) {
            rowCount = 5;
        }

        page.setCurrentPage(current);
        page.setRows(rowCount);
        //调用Dao查询总记录数
        int totalCount = Math.toIntExact(userDao.findTotalCount(condition));
        page.setTotalCount(totalCount);
        int start = (current - 1) * rowCount;
        //调用dao查询User
        List<User> userList = userDao.findUserByPage(start, rowCount, condition);
        page.setList(userList);
        //计算页码总数
        int totalPage = 0;
        if (totalCount % rowCount == 0) {
            totalPage = totalCount / rowCount;
        } else {
            totalPage = totalCount / rowCount + 1;
        }
        page.setTotalPages(totalPage);
        return page;
    }
}
