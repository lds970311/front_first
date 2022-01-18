// Author : evan lee
// Time ： 2022-01-18  13:42
// FILENAME : DruildTest.java
// STATEMENT: 

package com.codewolf.connectionpool;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DruildTest {
    private static DataSource ds = null;

    static {
        Properties properties = new Properties();
        InputStream stream = DruildTest.class.getClassLoader().getResourceAsStream("druid.properties");
        try {
            properties.load(stream);
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SneakyThrows
    @Test
    public void druild() {
        Connection conn = ds.getConnection();
        System.out.println(conn);
    }

    public static Connection getDruidConnection() throws SQLException {
        return ds.getConnection();
    }
}
