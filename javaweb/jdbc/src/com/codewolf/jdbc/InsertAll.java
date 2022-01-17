// Author : evan lee
// Time ： 2022-01-17  22:09
// FILENAME : InsertAll.java
// STATEMENT: 批量插入

package com.codewolf.jdbc;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertAll {
    @SneakyThrows
    @Test
    public void insert() {
        long start = System.currentTimeMillis();
        Connection connection = JDBCUtils.getConnection();
        //设置事务隔离界别
        connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
        String sql = "insert into my_jdbc.goods(NAME) VALUES (?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        //不自动提交数据
        connection.setAutoCommit(false);
        for (int i = 0; i < 10000; i++) {
            statement.setString(1, "name" + i);
            statement.addBatch();
            if (i % 500 == 0) {
                statement.executeBatch();
                statement.clearBatch();
            }
        }
        statement.executeBatch();
        statement.clearBatch();
        //统一提交数据
        connection.commit();
        long end = System.currentTimeMillis();
        System.out.println("time = " + (end - start));
        connection.close();
        statement.close();
    }
}
