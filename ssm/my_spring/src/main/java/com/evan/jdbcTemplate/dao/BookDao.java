// AUTHOR: CSR丶SUSE
// TIME : 2022-02-02  22:57
// FILENAME: BookDao.java
// TOOLS : INTELLIJ IDEA
// STATEMENT: 


package com.evan.jdbcTemplate.dao;

import com.evan.jdbcTemplate.domain.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDao {
    /**
     * 添加
     *
     * @param book
     */
    void addBook(Book book);

    /**
     * 更新
     *
     * @param book
     */
    void updateBook(Book book);

    /**
     * 根据id删除
     *
     * @param id
     */
    void deleteBookById(int id);

    /**
     * 获取总数量
     *
     * @return int
     */
    int getBookCount();

    /**
     * 根据id获取
     *
     * @param id
     * @return book
     */
    Book getBookById(int id);

    /**
     * 获取全部
     *
     * @return list
     */
    List<Book> getAllBook();

    /**
     * 批量插入
     *
     * @param argsList
     */
    void insertBooks(List<Object[]> argsList);

    /**
     * 批量删除
     *
     * @param argsList
     */
    void deleteBooks(List<Object[]> argsList);
}
