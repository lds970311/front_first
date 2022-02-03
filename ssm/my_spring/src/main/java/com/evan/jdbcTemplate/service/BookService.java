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

@Service
public class BookService {
    @Autowired
    private BookDao bookDao;

    public void addBook(Book book) {
        bookDao.addBook(book);
    }
}
