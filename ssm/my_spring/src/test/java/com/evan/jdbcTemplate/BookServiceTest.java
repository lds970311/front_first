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
import java.util.Properties;

public class BookServiceTest {
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
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        bookService.addBook(book);
    }
}
