// Author : evan lee
// Time ： 2022-01-18  14:02
// FILENAME : DBUtilsTest.java
// STATEMENT: 

package com.codewolf.connectionpool;

import com.codewolf.beans.Customer;
import lombok.SneakyThrows;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class DBUtilsTest {
    @Test
    public void queryTest() {
        QueryRunner runner = new QueryRunner();
        try {
            Connection connection = DruildTest.getDruidConnection();
            String sql = "select id,name,email,birth from my_jdbc.customers where id = ?";
            BeanHandler<Customer> handler = new BeanHandler<>(Customer.class);
            Customer customer = runner.query(connection, sql, handler, 16);
            System.out.println(customer);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void queryTest2() {
        QueryRunner runner = new QueryRunner();
        try {
            Connection connection = DruildTest.getDruidConnection();
            String sql = "select id,name,email,birth from my_jdbc.customers";
            BeanListHandler<Customer> handler = new BeanListHandler<>(Customer.class);
            List<Customer> customers = runner.query(connection, sql, handler);
            customers.forEach(System.out::println);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @SneakyThrows
    @Test
    public void updateTest() {
        QueryRunner queryRunner = new QueryRunner();
        Connection connection = DruildTest.getDruidConnection();
        String sql = "update  my_jdbc.user set address = ? where id = ?";
        int update = queryRunner.update(connection, sql, "上海", 4);
        System.out.println(update);
        DbUtils.closeQuietly(connection);
    }
}
