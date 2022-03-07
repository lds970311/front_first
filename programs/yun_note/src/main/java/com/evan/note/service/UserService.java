// Author : evan lee
// Time ： 2022-02-28  22:14
// FILENAME : UserService.java
// STATEMENT: 

package com.evan.note.service;

import com.evan.note.pojo.User;
import com.evan.note.vo.ResultInfo;

import javax.servlet.http.HttpServletRequest;
@SuppressWarnings("all")
public interface UserService {
    /**
     * 用户登录
     *
     * @param username
     * @param password
     * @return resultinfo
     */
    ResultInfo<User> userLogin(String username, String password);

    Integer checkNickName(String nickName, Integer userId);

    ResultInfo<User> saveUserInfo(HttpServletRequest req);

    /**
     * 注册用户
     *
     * @param userName
     * @param password
     * @return
     */
    ResultInfo<User> register(String userName, String password);
}
