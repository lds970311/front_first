// Author : evan lee
// Time ： 2022-01-17  21:24
// FILENAME : BlobQuery.java
// STATEMENT: 

package com.codewolf.jdbc;

import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;

public class BlobQuery {

    @Test
    public void blobQuery() {
        Connection connection = JDBCUtils.getConnection();
        FileOutputStream outputStream = null;
        PreparedStatement statement = null;
        String sql = "select photo from my_jdbc.customers where id = ?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setObject(1, 18);
            ResultSet resultSet = statement.executeQuery();
            System.out.println(resultSet);
            if (resultSet.next()) {
                Blob blob = resultSet.getBlob(1);
                InputStream binaryStream = blob.getBinaryStream();
                outputStream = new FileOutputStream("F:\\Java\\front_first\\javaweb\\jdbc\\temp\\02.jpeg");
                byte[] buf = new byte[512];
                int len = 0;
                while ((len = binaryStream.read(buf)) != -1) {
                    outputStream.write(buf, 0, len);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
