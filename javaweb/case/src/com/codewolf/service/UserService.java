// Author : evan lee
// Time ： 2022-01-21  18:55
// FILENAME : UserService.java
// STATEMENT: 

package com.codewolf.service;

import com.codewolf.domain.User;

import java.util.List;

/**
 * 用户管理业务接口
 */
public interface UserService {
    /**
     * 查询所有用户信息
     *
     * @return all
     */
    List<User> findAll();

    void insert(User user);

    void deleteById(String id);
}
