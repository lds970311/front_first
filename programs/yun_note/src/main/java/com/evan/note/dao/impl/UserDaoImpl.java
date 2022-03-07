// Author : evan lee
// Time ： 2022-02-28  22:14
// FILENAME : UserDaoImpl.java
// STATEMENT: 

package com.evan.note.dao.impl;

import com.evan.note.dao.UserDao;
import com.evan.note.pojo.User;
import com.evan.note.utils.JDBCUtils;

public class UserDaoImpl implements UserDao {

    @Override
    public User getUserByName(String name) {
        String sql = "select * from yun_note.tb_user where uname = ?";
        return JDBCUtils.queryOne(User.class, sql, name);
    }

    @Override
    public User queryUserByNickName(String nickName, Integer userId) {
        String sql = "select * from yun_note.tb_user where nick = ? and userId <> ?";
        return JDBCUtils.queryOne(User.class, sql, nickName, userId);
    }

    @Override
    public int updateUser(User user) {
        String sql = "update yun_note.tb_user set nick = ?,mood = ? where userId = ?";
        return JDBCUtils.update(sql, user.getNick(), user.getMood(), user.getUserId());
    }

    @Override
    public int registerUser(String userName, String password) {
        String sql = "insert into tb_user(uname,upwd) values(?,?)";
        return JDBCUtils.update(sql, userName, password);
    }
}
