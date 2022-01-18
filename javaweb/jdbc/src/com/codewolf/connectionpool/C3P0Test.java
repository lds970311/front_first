// Author : evan lee
// Time ： 2022-01-18  12:44
// FILENAME : C3P0Test.java
// STATEMENT: 

package com.codewolf.connectionpool;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;

public class C3P0Test {
    private static final DataSource dataSource = new ComboPooledDataSource("hello-c3p0");

    public static Connection c3p0Connection() throws Exception {
        return dataSource.getConnection();
    }
}
