// AUTHOR: CSR丶SUSE
// TIME : 2022-02-02  22:57
// FILENAME: BookDao.java
// TOOLS : INTELLIJ IDEA
// STATEMENT: 


package com.evan.jdbcTemplate.dao;

import com.evan.jdbcTemplate.domain.Book;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDao {
    void addBook(Book book);
}
