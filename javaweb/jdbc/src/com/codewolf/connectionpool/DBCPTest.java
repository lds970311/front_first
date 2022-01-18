// Author : evan lee
// Time ： 2022-01-18  13:13
// FILENAME : DBCPTest.java
// STATEMENT: 

package com.codewolf.connectionpool;

import org.apache.commons.dbcp2.BasicDataSourceFactory;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DBCPTest {
    private static DataSource source = null;

    static {
        try {
            Properties pros = new Properties();

            InputStream is = DBCPTest.class.getClassLoader().getResourceAsStream("dbcp.properties");

            pros.load(is);
            //根据提供的BasicDataSourceFactory创建对应的DataSource对象
            source = BasicDataSourceFactory.createDataSource(pros);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void dbcp() {
        try {
            Connection connection = source.getConnection();
            System.out.println(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
