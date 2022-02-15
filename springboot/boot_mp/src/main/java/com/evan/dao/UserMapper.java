// Author : evan lee
// Time ： 2022-02-14  13:19
// FILENAME : UserMapper.java
// STATEMENT: 

package com.evan.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.evan.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    User findByName(String name);
}
