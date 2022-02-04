// AUTHOR: CSR丶SUSE
// TIME : 2022-02-02  22:57
// FILENAME: BookService.java
// TOOLS : INTELLIJ IDEA
// STATEMENT: 


package com.evan.jdbcTemplate.service;

import com.evan.jdbcTemplate.dao.BookDao;
import com.evan.jdbcTemplate.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
@Transactional()
public class BookService {
    @Autowired
    private BookDao bookDao;

    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    public void deleteBookById(int id) {
        bookDao.deleteBookById(id);
    }

    public int getBookCount() {
        return bookDao.getBookCount();
    }

    public Book getBookById(int id) {
        return bookDao.getBookById(id);
    }

    public List<Book> getAllBook() {
        return bookDao.getAllBook();
    }

    public void insertBooks() {
        Object[][] args = {
                {"四世同堂", "老舍"},
                {"史记", "司马迁"}
        };
        List<Object[]> list = Arrays.asList(args);
        bookDao.insertBooks(list);
    }

    public void deleteBooks() {
        Object[][] args = {
                {7}, {3}, {5}
        };
        bookDao.deleteBooks(Arrays.asList(args));
    }
}
