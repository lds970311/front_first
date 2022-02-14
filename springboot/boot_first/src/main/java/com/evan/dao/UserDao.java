// Author : evan lee
// Time ： 2022-02-14  0:00
// FILENAME : UserDao.java
// STATEMENT: 

package com.evan.dao;

import com.evan.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserDao {
    User getUserById(@Param("id") Integer id);

    List<User> getAllUsers();
}
