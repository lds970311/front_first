// Author : evan lee
// Time ： 2022-02-16  1:01
// FILENAME : BookTest.java
// STATEMENT: 

package com.evan.boot_ssmp;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.evan.boot_ssmp.domain.Book;
import com.evan.boot_ssmp.mapper.BookMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@SpringBootTest
@Transactional
@Rollback(value = false)
public class BookTest {

    @Resource
    private BookMapper bookMapper;

    @Test
    void testSaveBook() {
        Book book = new Book(null, "倚天屠龙记", "禁用", 32.0, 50, 50, "yttlj.jpj");
        int insert = bookMapper.insert(book);
        System.out.println(insert);
    }

    @Test
    void testUpdate() {
        Book book = new Book(null, "倚天屠龙记", "禁用", 32.0, 50, 50, "yttlj.jpj");
        UpdateWrapper<Book> bookUpdateWrapper = new UpdateWrapper<>();
        bookUpdateWrapper.eq("id", 62)
                .set("author", "金庸");
        this.bookMapper.update(book, bookUpdateWrapper);
    }
}
