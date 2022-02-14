// Author : evan lee
// Time ： 2022-02-14  0:28
// FILENAME : UserService.java
// STATEMENT: 

package com.evan.service;

import com.evan.dao.UserDao;
import com.evan.domain.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {

    @Resource
    private UserDao userDao;

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}
