// Author : evan lee
// Time ： 2022-01-21  19:04
// FILENAME : MySQLUtils.java
// STATEMENT: 

package com.codewolf.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class MySQLUtils {
    private static DataSource dataSource = null;

    static {
        Properties properties = new Properties();
        InputStream inputStream = MySQLUtils.class.getClassLoader().getResourceAsStream("druid.properties");
        try {
            properties.load(inputStream);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private MySQLUtils() {

    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
