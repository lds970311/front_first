// Author : evan lee
// Time ： 2022-02-28  22:14
// FILENAME : UserDaoImpl.java
// STATEMENT: 

package com.evan.note.dao.iml;

import com.evan.note.dao.UserDao;
import com.evan.note.pojo.User;
import com.evan.note.utils.JDBCUtils;

public class UserDaoImpl implements UserDao {

    @Override
    public User getUserByName(String name) {
        String sql = "select * from yun_note.tb_user where uname = ?";
        return JDBCUtils.queryOne(User.class, sql, name);
    }
}
