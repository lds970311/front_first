// Author : evan lee
// Time ： 2022-02-15  20:17
// FILENAME : MyBaseMapper.java
// STATEMENT: 

package com.evan.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MyBaseMapper<T> extends BaseMapper<T> {

    List<T> findByAge(@Param("age") Wrapper<T> queryWrapper);
}
