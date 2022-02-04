// AUTHOR: CSR丶SUSE
// TIME : 2022-02-02  22:57
// FILENAME: BookDaoImpl.java
// TOOLS : INTELLIJ IDEA
// STATEMENT: 


package com.evan.jdbcTemplate.dao;

import com.evan.jdbcTemplate.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addBook(Book book) {
        String sql = "insert into jdbctemplate.book(name, author) value (?,?)";
        int update = jdbcTemplate.update(sql, book.getName(), book.getAuthor());
        if (update > 0) {
            System.out.println("insert success!");
        }
    }

    @Override
    public void updateBook(Book book) {
        String sql = "update jdbctemplate.book set name = ?,author = ? where id = ?";
        int update = jdbcTemplate.update(sql, book.getName(), book.getAuthor(), book.getId());
        if (update > 0) {
            System.out.println("update success!");
        }
    }

    @Override
    public void deleteBookById(int id) {
        String sql = "delete from jdbctemplate.book where id = ?;";
        int update = jdbcTemplate.update(sql, id);
        if (update > 0) {
            System.out.println("update success!");
        }
    }

    @Override
    public int getBookCount() {
        String sql = "select count(*) from jdbctemplate.book;";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count;
    }

    @Override
    public Book getBookById(int id) {
        String sql = "select * from jdbctemplate.book where id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Book.class), id);
    }

    @Override
    public List<Book> getAllBook() {
        String sql = "select * from jdbctemplate.book";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Book.class));
    }

    @Override
    public void insertBooks(List<Object[]> argsList) {
        String sql = "insert into jdbctemplate.book(name, author) VALUES (?,?)";
        int[] ints = jdbcTemplate.batchUpdate(sql, argsList);
        System.out.println(Arrays.toString(ints));
    }

    @Override
    public void deleteBooks(List<Object[]> argsList) {
        String sql = "delete from jdbctemplate.book where id = ?";
        int[] ints = jdbcTemplate.batchUpdate(sql, argsList);
        System.out.println(Arrays.toString(ints));
        System.out.println("delete success");
    }
}
