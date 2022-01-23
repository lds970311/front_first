// Author : evan lee
// Time ： 2022-01-21  18:55
// FILENAME : UserService.java
// STATEMENT: 

package com.codewolf.service;

import com.codewolf.domain.PageBean;
import com.codewolf.domain.User;

import java.util.List;
import java.util.Map;

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

    User findUserById(String id);

    void updateUser(User user);

    /**
     * 分页条件查询
     *
     * @param currentPage 当前页
     * @param rows        每页显示的条数
     * @param condition   条件map
     * @return page
     */
    PageBean<User> findUserByPage(String currentPage, String rows, Map<String, String[]> condition);
}
