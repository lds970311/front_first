// Author : evan lee
// Time ： 2022-01-19  20:16
// FILENAME : DBTest.java
// STATEMENT: 

package com.evan.web.login;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.evan.web.beans.UserInfo;
import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

@SuppressWarnings("all")
public class ConnectionCreator {
    public static DataSource dataSource = null;

    static {
        Properties properties = new Properties();
        InputStream inputStream = ConnectionCreator.class.getClassLoader().getResourceAsStream("druid.properties");
        try {
            properties.load(inputStream);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SneakyThrows
    @Test
    public void dbTest() {
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select user, password from my_jdbc.user_table where id = ?";
        BeanHandler<UserInfo> handler = new BeanHandler<UserInfo>(UserInfo.class);
        UserInfo info = queryRunner.query(connection, sql, handler, 6);
        System.out.println(info);
    }

    public static Connection getDBConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
