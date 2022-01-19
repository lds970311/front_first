// Author : evan lee
// Time ： 2022-01-19  22:03
// FILENAME : UserDao.java
// STATEMENT: 

package com.evan.web.login;

import com.evan.web.beans.UserInfo;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDao {
    private static final Connection connection = ConnectionCreator.getDBConnection();

    private UserDao() {

    }

    public static UserInfo getUser(String username, String password) {
        QueryRunner queryRunner = new QueryRunner();
        UserInfo userInfo = new UserInfo();
        String sql = "select user, password from my_jdbc.user_table where user = ? and password = ?";
        BeanHandler<UserInfo> handler = new BeanHandler<>(UserInfo.class);
        try {
            userInfo = queryRunner.query(connection, sql, handler, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userInfo;
    }

    @Test
    public void runnerTest() {
        UserInfo user = getUser("zhangsan", "hehe");
        System.out.println(user);
    }
}
