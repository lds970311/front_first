// Author : evan lee
// Time ： 2022-02-27  21:57
// FILENAME : JDBCUtils.java
// STATEMENT: jdbc工具类

package com.evan.note.utils;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.Properties;

@Slf4j
public class JDBCUtils {
    private static final Properties properties;

    static {
        properties = new Properties();
        //加载配置文件
        InputStream inputStream = JDBCUtils.class.getClassLoader().getResourceAsStream("db.properties");
        try {
            properties.load(inputStream);
            String driverClassName = properties.getProperty("DriverClassName");
            //加载驱动
            Class.forName(driverClassName);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @SneakyThrows
    public static Connection getConnection() {
        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        log.info("在{}时，获取数据库连接", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        return DriverManager.getConnection(url, username, password);
    }

    /**
     * 关闭资源
     *
     * @param resultSet
     * @param statement
     * @param connection
     */
    public static void closeResource(ResultSet resultSet, PreparedStatement statement, Connection connection) {
        Optional.ofNullable(resultSet)
                .ifPresent(resultSet1 -> {
                    try {
                        resultSet1.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                });
        Optional.ofNullable(statement)
                .ifPresent(s -> {
                    try {
                        s.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                });
        Optional.ofNullable(connection)
                .ifPresent(c -> {
                    try {
                        c.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                });
    }
}
