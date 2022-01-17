// Author : evan lee
// Time ： 2022-01-17  12:25
// FILENAME : JDBCUtils.java
// STATEMENT: 

package com.codewolf.jdbc;

import com.codewolf.beans.Customer;
import com.codewolf.beans.Order;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class JDBCUtils {
    public static Connection getConnection() {
        InputStream inputStream = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        Connection connection = null;
        try {
            properties.load(inputStream);
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            String url = properties.getProperty("url");
            String driver = properties.getProperty("driver");
            Class<?> cls = Class.forName(driver);
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static int update(String sql, Object... args) {
        Connection connection = getConnection();
        if (connection == null) {
            System.out.println("连接失败!");
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
            StatementTest.closeResource(stmt, connection);
        }
        return 0;
    }

    /**
     * 查询customer表中的数据
     *
     * @param sql  sql语句
     * @param args 占位符
     * @return customer
     */
    public static Customer queryCustomer(String sql, Object... args) {
        Connection connection = getConnection();
        Customer customer = null;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                stmt.setObject(i + 1, args[i]);
            }
            ResultSet resultSet = stmt.executeQuery();
            customer = new Customer();
            if (resultSet.next()) {
                //获取列数,列明
                ResultSetMetaData metaData = resultSet.getMetaData();
                int count = metaData.getColumnCount();
                for (int i = 0; i < count; i++) {
                    String label = metaData.getColumnLabel(i + 1);
                    Object result = resultSet.getObject(i + 1);
                    //反射获取对应字段, 名设置值
                    Field field = Customer.class.getDeclaredField(label);
                    field.setAccessible(true);
                    field.set(customer, result);
                }
            }
        } catch (SQLException | NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return customer;
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
            System.out.println("mysql连接失败");
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
                    String label = toCamelCase(metaData.getColumnLabel(i + 1));
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

    private static String toCamelCase(String label) {
        String[] s = label.split("_");
        StringBuilder stringBuilder = new StringBuilder();
        for (String s1 : s) {
            if (stringBuilder.length() == 0) {
                stringBuilder.append(s1);
            } else {
                stringBuilder.append(s1.substring(0, 1).toUpperCase());
                stringBuilder.append(s1.substring(1).toLowerCase());
            }
        }
        return stringBuilder.toString();
    }

    @Test
    public void queryTest() {
        String sql = "select name, email, birth\n" +
                "from customers\n" +
                "where id = ?;";
        Customer customer = queryCustomer(sql, 1);
        System.out.println(customer);
    }

    @Test
    public void queryAllTest() {
        String sql = "select order_name, order_date\n" +
                "from my_jdbc.`order`";
        try {
            List<Order> all = queryAll(Order.class, sql);
            assert all != null;
            all.forEach(System.out::println);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
