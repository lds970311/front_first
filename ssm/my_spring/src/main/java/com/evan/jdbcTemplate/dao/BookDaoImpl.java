// AUTHOR: CSR丶SUSE
// TIME : 2022-02-02  22:57
// FILENAME: BookDaoImpl.java
// TOOLS : INTELLIJ IDEA
// STATEMENT: 


package com.evan.jdbcTemplate.dao;

import com.evan.jdbcTemplate.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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
}
