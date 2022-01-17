// Author : evan lee
// Time ： 2022-01-17  10:56
// FILENAME : StatementTest.java
// STATEMENT: 

package com.codewolf.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class StatementTest {

    @SuppressWarnings("all")
    public static void create() throws Exception {
        Connection connection = ConnectionTest.getConnection();
        String sql = "insert into `order`(`order_name`, `order_date`) values (?, ?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, "DDEE");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = dateFormat.parse("1998-10-10");
        stmt.setDate(2, new Date(date.getTime()));
        stmt.execute();
        closeResource(stmt, connection);
    }

    public static void update() {
        try {
            Connection connection = ConnectionTest.getConnection();
            String sql = "update my_jdbc.user set name = ? where id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, "杨超越");
            stmt.setInt(2, 4);
            stmt.execute();
            closeResource(stmt, connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void closeResource(PreparedStatement stmt, Connection connection) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try {
            update();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
