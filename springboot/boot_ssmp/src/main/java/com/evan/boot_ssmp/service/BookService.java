package com.evan.boot_ssmp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.evan.boot_ssmp.domain.Book;

import java.util.List;

/**
 * @author mechrevo
 * @description 针对表【book】的数据库操作Service
 * @createDate 2022-02-16 00:26:29
 */
public interface BookService {
    boolean save(Book book);

    boolean delete(Integer id);

    boolean update(Book book);

    Book getById(Integer id);

    List<Book> getAll();

    IPage<Book> getByPage(int currentPage, int pageSize);

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    Integer batchDelete(String ids);

    IPage<Book> getByPage(Integer pageNum, Integer pageSize, String title, String author, Double price);

}
