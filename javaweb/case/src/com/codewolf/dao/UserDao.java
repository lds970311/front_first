// Author : evan lee
// Time ： 2022-01-21  18:58
// FILENAME : UserDao.java
// STATEMENT: 

package com.codewolf.dao;

import com.codewolf.domain.User;

import java.util.List;
import java.util.Map;

/**
 * 用户操作的DAO
 */
public interface UserDao {
    List<User> findAll();

    void insert(User user);

    void deleteById(String id);

    User findUserById(String id);

    void updateUser(User user);

    Long findTotalCount(Map<String, String[]> condition);

    List<User> findUserByPage(int start, int rowCount, Map<String, String[]> condition);
}
