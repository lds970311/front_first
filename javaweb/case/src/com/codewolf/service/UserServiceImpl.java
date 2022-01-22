// Author : evan lee
// Time ： 2022-01-21  18:56
// FILENAME : UserServiceImpl.java
// STATEMENT: 

package com.codewolf.service;

import com.codewolf.dao.UserDao;
import com.codewolf.dao.UserDaoImpl;
import com.codewolf.domain.User;

import java.util.List;

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
}
