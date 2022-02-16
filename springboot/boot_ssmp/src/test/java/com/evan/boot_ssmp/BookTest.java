// Author : evan lee
// Time ： 2022-02-16  1:01
// FILENAME : BookTest.java
// STATEMENT: 

package com.evan.boot_ssmp;

import com.evan.boot_ssmp.domain.Book;
import com.evan.boot_ssmp.mapper.BookMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class BookTest {

    @Resource
    private BookMapper bookMapper;

    @Test
    public void testGetBook() {
        Book book = bookMapper.selectById(1);
        System.out.println("根据id获取的:" + book);
        List<Book> books = bookMapper.selectList(null);
        System.out.println("-----all books:------");
        books.forEach(System.out::println);
    }
}
