package com.evan.boot_ssmp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.evan.boot_ssmp.domain.Book;
import com.evan.boot_ssmp.mapper.BookMapper;
import com.evan.boot_ssmp.service.BookService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author mechrevo
 * @description 针对表【book】的数据库操作Service实现
 * @createDate 2022-02-16 00:26:29
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;

    @Override
    public boolean save(Book book) {
        return bookMapper.insert(book) > 0;
    }

    @Override
    public boolean delete(Integer id) {
        return bookMapper.deleteById(id) > 0;
    }

    @Override
    public boolean update(Book book) {
        return bookMapper.updateById(book) > 0;
    }

    @Override
    public Book getById(Integer id) {
        return bookMapper.selectById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookMapper.selectList(null);
    }

    @Override
    public IPage<Book> getByPage(int currentPage, int pageSize) {
        IPage<Book> page = new Page<>(currentPage, pageSize);
        bookMapper.selectPage(page, null);
        return page;
    }


    @Override
    public Integer batchDelete(String ids) {
        String[] strings = ids.split(",");
        Integer count = 0;
        for (String string : strings) {
            Integer value = Integer.valueOf(string);
            boolean delete = this.delete(value);
            if (delete) {
                count++;
            }
        }
        return count;
    }

    @Override
    public IPage<Book> getByPage(Integer pageNum, Integer pageSize, String title, String author, Double price) {
        LambdaQueryWrapper<Book> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(Strings.isNotEmpty(title), Book::getTitle, title)
                .like(Strings.isNotEmpty(author), Book::getAuthor, author)
                .like(price != null, Book::getPrice, price);
        Page<Book> page = new Page<>(pageNum, pageSize);
        this.bookMapper.selectPage(page, wrapper);
        return page;
    }
}




