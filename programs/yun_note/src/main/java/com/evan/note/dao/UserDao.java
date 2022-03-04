// Author : evan lee
// Time ： 2022-02-28  22:14
// FILENAME : UserDao.java
// STATEMENT: 

package com.evan.note.dao;

import com.evan.note.pojo.User;

public interface UserDao {
    /**
     * 通过用户名查询用户
     *
     * @param name
     * @return
     */
    User getUserByName(String name);

    User queryUserByNickName(String nickName, Integer userId);

    /**
     * 更新用户信息
     *
     * @param user
     * @return
     */
    int updateUser(User user);
}
