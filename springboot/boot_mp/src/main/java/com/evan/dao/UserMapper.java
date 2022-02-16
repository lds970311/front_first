// Author : evan lee
// Time ： 2022-02-14  13:19
// FILENAME : UserMapper.java
// STATEMENT: 

package com.evan.dao;

import com.evan.domain.User;
import com.evan.mapper.MyBaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper extends MyBaseMapper<User> {
    List<User> findByName(String name);

    int deleteAll();
}
