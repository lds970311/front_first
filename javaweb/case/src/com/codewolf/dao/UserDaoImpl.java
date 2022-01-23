// Author : evan lee
// Time ： 2022-01-21  18:59
// FILENAME : UserDaoImpl.java
// STATEMENT: 

package com.codewolf.dao;

import com.codewolf.domain.User;
import com.codewolf.utils.MySQLUtils;
import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

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

    @SneakyThrows
    @Override
    public User findUserById(String id) {
        Integer No = Integer.valueOf(id);
        QueryRunner runner = new QueryRunner();
        BeanHandler<User> handler = new BeanHandler<>(User.class);
        String sql = "select * from mydb.user where id = ?";
        return runner.query(connection, sql, handler, No);
    }

    @SneakyThrows
    @Override
    public void updateUser(User user) {
        Integer id = user.getId();
        QueryRunner runner = new QueryRunner();
        String sql = "update mydb.user set name = ? , age = ? , gender = ?, address = ?, qq = ?," +
                " email = ? where id = ?";
        runner.update(connection, sql, user.getName(), user.getAge(), user.getGender(), user.getAddress(),
                user.getQq(), user.getEmail(), id);
    }

    @SneakyThrows
    @Override
    public Long findTotalCount(Map<String, String[]> condition) {
        //1.定义模板初始化sql
        String sql = "select count(*) from mydb.user where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        List<Object> params = new ArrayList<>();
        //2.遍历map
        Set<String> keySet = condition.keySet();
        for (String key : keySet) {
            //排除分页条件参数
            if ("currentPage".equals(key) || "rows".equals(key)) {
                continue;
            }

            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if (value != null && !"".equals(value)) {
                //有值
                sb.append(" and ").append(key).append(" like ? ");
                params.add("%" + value + "%");//？条件的值
            }
        }
        QueryRunner runner = new QueryRunner();

        ScalarHandler<Long> handler = new ScalarHandler<>();
        return runner.query(connection, sb.toString(), handler, params.toArray());
    }

    @SneakyThrows
    @Override
    public List<User> findUserByPage(int start, int rowCount, Map<String, String[]> condition) {
        //1.定义模板初始化sql
        String sql = "select * from mydb.user where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        List<Object> params = new ArrayList<>();
        //2.遍历map
        Set<String> keySet = condition.keySet();
        for (String key : keySet) {
            //排除分页条件参数
            if ("currentPage".equals(key) || "rows".equals(key)) {
                continue;
            }

            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if (value != null && !"".equals(value)) {
                //有值
                sb.append(" and ").append(key).append(" like ? ");
                params.add("%" + value + "%");//？条件的值
            }
        }
        sb.append(" limit ?,? ");
        //添加分页查询参数值
        params.add(start);
        params.add(rowCount);
        QueryRunner queryRunner = new QueryRunner();
        BeanListHandler<User> handler = new BeanListHandler<>(User.class);
        return queryRunner.query(connection, sb.toString(), handler, params.toArray());
    }
}
