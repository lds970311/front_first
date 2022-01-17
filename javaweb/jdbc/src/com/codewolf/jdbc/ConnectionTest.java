// Author : evan lee
// Time ： 2022-01-17  0:37
// FILENAME : ConnectionTest.java
// STATEMENT: 

package com.codewolf.jdbc;


import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionTest {
    /**
     * 获取mysql 数据库连接
     *
     * @return Connection
     * @throws Exception e
     */
    public static Connection getConnection() throws Exception {
        //读取配置文件方式获取Connection
        InputStream stream = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        properties.load(stream);
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");
        //获取驱动
        Class<?> cls = Class.forName(driver);
        return DriverManager.getConnection(url, user, password);
    }

    public static Connection getConnection2() throws Exception {
        //方式2
        //获取driver
        Class<?> cla = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver) cla.getDeclaredConstructor().newInstance();
        // 2. 注册驱动(可省略,)
        DriverManager.registerDriver(driver);
        //3. 获取连接
        return DriverManager.getConnection("jdbc:mysql://192.168.208.146:3306/my_jdbc", "root", "19970311");
    }

    public static Connection getConnection3() throws Exception {
        Class<?> cla = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver) cla.getDeclaredConstructor().newInstance();
        String url = "jdbc:mysql://192.168.208.146:3306/my_jdbc";
        //用户名 密码卸载property里面
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "19970311");
        return driver.connect(url, info);
    }

    @Test
    public void connection() throws Exception {
        Connection connection = getConnection();
        System.out.println(connection);
    }

    @Test
    public void test() {
        System.out.println(123);
    }
}
