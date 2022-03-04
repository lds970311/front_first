// Author : evan lee
// Time ： 2022-02-27  21:51
// FILENAME : DBTest.java
// STATEMENT: 

package com.evanlee.note;

import com.evan.note.pojo.User;
import com.evan.note.utils.JDBCUtils;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

public class DBTest {
    @Test
    void testQueryOne() {
        String sql = "select * from yun_note.tb_user";
        User user = JDBCUtils.queryOne(User.class, sql);
        System.out.println(user);
    }

    @SneakyThrows
    @Test
    void testStringValue() {
        String sql = "select count(*) from tb_user";
        Object value = JDBCUtils.findSingleValue(sql);
        System.out.println(value);
    }
}
