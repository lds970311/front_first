// Author : evan lee
// Time ： 2022-01-21  18:59
// FILENAME : UserDaoImpl.java
// STATEMENT: 

package com.codewolf.dao;

import com.codewolf.domain.User;
import com.codewolf.utils.MySQLUtils;
import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private static Connection connection = null;

    static {
        try {
            connection = MySQLUtils.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> findAll() {
        //使用JDBC操作数据库
        List<User> users = null;
        try {
            QueryRunner runner = new QueryRunner();
            BeanListHandler<User> handler = new BeanListHandler<>(User.class);
            String sql = "select * from mydb.user";
            users = runner.query(connection, sql, handler);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    @SneakyThrows
    @Override
    public void insert(User u) {
        QueryRunner runner = new QueryRunner();
        String name = u.getName();
        Integer age = u.getAge();
        String gender = u.getGender();
        String address = u.getAddress();
        String qq = u.getQq();
        String email = u.getEmail();
        String sql = "insert into mydb.user ( name, age, gender, address, qq, email) values (?,?,?,?,?,?)";
        runner.update(connection, sql, name, age, gender, address, qq, email);
    }

    @SneakyThrows
    @Override
    public void deleteById(String id) {
        Integer no = Integer.valueOf(id);
        QueryRunner runner = new QueryRunner();
        String sql = "delete from mydb.user where id = ?";
        runner.update(connection, sql, no);
    }
}
