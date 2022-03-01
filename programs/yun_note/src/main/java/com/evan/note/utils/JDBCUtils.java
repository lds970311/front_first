// Author : evan lee
// Time ： 2022-02-27  21:57
// FILENAME : JDBCUtils.java
// STATEMENT: jdbc工具类

package com.evan.note.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SneakyThrows
    public static Connection getConnection() {
        DataSource ds = DruidDataSourceFactory.createDataSource(properties);
        return ds.getConnection();
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

    /**
     * 通用jdbc查询
     *
     * @param cls  运行时类
     * @param sql  sql语句
     * @param args 占位符
     * @param <T>
     * @return List
     */
    public static <T> List<T> queryAll(Class<T> cls, String sql, Object... args) throws SQLException {
        Connection connection = getConnection();
        List<T> list = null;
        if (connection == null) {
            log.error("mysql连接失败");
            return null;
        }
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                stmt.setObject(i + 1, args[i]);
            }
            ResultSet resultSet = stmt.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            list = new ArrayList<>();
            while (resultSet.next()) {
                T t = cls.getDeclaredConstructor().newInstance();
                for (int i = 0; i < columnCount; i++) {
                    String label = metaData.getColumnLabel(i + 1);
                    Object value = resultSet.getObject(i + 1);
                    //反射获取字段
                    Field field = cls.getDeclaredField(label);
                    field.setAccessible(true);
                    field.set(t, value);
                }
                list.add(t);
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
            if (stmt != null) {
                stmt.close();
            }
        }
        return null;
    }

    @SneakyThrows
    public static <T> T queryOne(Class<T> cls, String sql, Object... args) {
        Connection connection = getConnection();
        T instance = null;
        if (connection == null) {
            log.error("mysql连接失败");
            return null;
        }
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        for (int i = 0; i < args.length; i++) {
            preparedStatement.setObject(i + 1, args[i]);
        }
        ResultSet resultSet = preparedStatement.executeQuery();
        //获取元数据
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        if (resultSet.next()) {
            instance = cls.getDeclaredConstructor().newInstance();
            for (int i = 0; i < columnCount; i++) {
                String columnLabel = metaData.getColumnLabel(i + 1);
                Field field = cls.getDeclaredField(columnLabel);
                Object value = resultSet.getObject(i + 1);
                field.setAccessible(true);
                field.set(instance, value);
            }
        }
        return instance;
    }

    public static int update(String sql, Object... args) {
        Connection connection = getConnection();
        if (connection == null) {
            log.error("mysql连接失败");
            return 0;
        }
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                stmt.setObject(i + 1, args[i]);
            }
            return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResource(null, stmt, connection);
        }
        return 0;
    }
}
