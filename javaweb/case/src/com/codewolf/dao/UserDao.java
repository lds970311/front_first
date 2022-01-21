// Author : evan lee
// Time ： 2022-01-21  18:58
// FILENAME : UserDao.java
// STATEMENT: 

package com.codewolf.dao;

import com.codewolf.domain.User;

import java.util.List;

/**
 * 用户操作的DAO
 */
public interface UserDao {
    List<User> findAll();

    void insert(User user);

    void deleteById(String id);
}
