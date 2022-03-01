// Author : evan lee
// Time ： 2022-02-27  21:51
// FILENAME : DBTest.java
// STATEMENT: 

package com.evanlee.note;

import com.evan.note.pojo.User;
import com.evan.note.utils.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

public class DBTest {
    @Test
    void connectionTest() {
        Connection connection = JDBCUtils.getConnection();
        System.out.println(connection);
        JDBCUtils.closeResource(null, null, connection);
    }

    @Test
    void testQueryOne() {
        String sql = "select * from yun_note.tb_user";
        User user = JDBCUtils.queryOne(User.class, sql);
        System.out.println(user);
    }
}
