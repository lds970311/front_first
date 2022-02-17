// Author : evan lee
// Time ： 2022-02-16  20:36
// FILENAME : BookserviceTest.java
// STATEMENT: 

package com.evan.boot_ssmp;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.evan.boot_ssmp.domain.Book;
import com.evan.boot_ssmp.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class BookServiceTest {
    @Resource
    private BookService bookService;

    @Test
    public void selectTest() {
        List<Book> all = bookService.getAll();
        all.forEach(System.out::println);
        System.out.println("----------------------");
        Book byId = bookService.getById(2);
        System.out.println(byId);
    }

    @Test
    public void pageTest() {
        IPage<Book> byPage = bookService.getByPage(2, 3);
        List<Book> records = byPage.getRecords();
        records.forEach(System.out::println);
    }
}
