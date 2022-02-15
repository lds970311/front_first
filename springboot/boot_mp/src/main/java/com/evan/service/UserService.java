// Author : evan lee
// Time ： 2022-02-14  13:48
// FILENAME : UserService.java
// STATEMENT: 

package com.evan.service;

import com.evan.dao.UserMapper;
import com.evan.domain.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    public List<User> getAllUsers() {
        return userMapper.selectList(null);
    }
}
