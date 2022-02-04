// AUTHOR: CSR丶SUSE
// TIME : 2022-02-02  23:16
// FILENAME: BookServiceTest.java
// TOOLS : INTELLIJ IDEA
// STATEMENT: 


package com.evan.jdbcTemplate;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.evan.jdbcTemplate.domain.Book;
import com.evan.jdbcTemplate.service.BookService;
import lombok.SneakyThrows;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.List;
import java.util.Properties;

public class BookServiceTest {
    private BookService getBookService() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        return context.getBean("bookService", BookService.class);
    }

    @SneakyThrows
    @Test
    public void druidTest() {
        Properties pro = new Properties();
        InputStream inputStream = BookServiceTest.class.getClassLoader().getResourceAsStream("druid.properties");
        pro.load(inputStream);
        DataSource dataSource = DruidDataSourceFactory.createDataSource(pro);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }


    @Test
    public void addTest() {
        Book book = new Book(1, "红楼梦", "曹雪芹");
        BookService bookService = this.getBookService();
        bookService.addBook(book);
    }

    @Test
    public void updateTest() {
        BookService bookService = this.getBookService();
        bookService.updateBook(new Book(13, "悲惨世界", "维克多.雨果"));
    }

    @Test
    public void deleteTest() {
        BookService bookService = this.getBookService();
        bookService.deleteBookById(1);
    }

    @Test
    public void getBookCountTest() {
        BookService bookService = this.getBookService();
        int bookCount = bookService.getBookCount();
        System.out.println(bookCount);
    }

    @Test
    public void getBookByIdTest() {
        BookService bookService = this.getBookService();
        Book bookById = bookService.getBookById(7);
        System.out.println(bookById);
    }

    @Test
    public void getAllBookTest() {
        BookService bookService = this.getBookService();
        List<Book> allBook = bookService.getAllBook();
        System.out.println(allBook);
    }

    @Test
    public void insertBooksTest() {
        BookService bookService = this.getBookService();
        bookService.insertBooks();
    }

    @Test
    public void deleteBooksTest() {
        BookService bookService = this.getBookService();
        bookService.deleteBooks();
    }
}
