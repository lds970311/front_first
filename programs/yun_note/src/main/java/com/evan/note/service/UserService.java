// Author : evan lee
// Time ： 2022-02-28  22:14
// FILENAME : UserService.java
// STATEMENT: 

package com.evan.note.service;

import com.evan.note.pojo.User;
import com.evan.note.vo.ResultInfo;

public interface UserService {
    /**
     * 用户登录
     *
     * @param username
     * @param password
     * @return resultinfo
     */
    ResultInfo<User> userLogin(String username, String password);
}
