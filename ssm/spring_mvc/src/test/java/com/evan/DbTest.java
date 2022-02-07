// AUTHOR: CSR丶SUSE
// TIME : 2022-02-06  23:23
// FILENAME: DbTest.java
// TOOLS : INTELLIJ IDEA
// STATEMENT: 


package com.evan;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import lombok.SneakyThrows;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class DbTest {
    @SneakyThrows
    @Test
    public void dataSourceTest() {
        Properties pro = new Properties();
        InputStream inputStream = DbTest.class.getClassLoader().getResourceAsStream("druid.properties");
        pro.load(inputStream);
        DataSource dataSource = DruidDataSourceFactory.createDataSource(pro);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }
}
