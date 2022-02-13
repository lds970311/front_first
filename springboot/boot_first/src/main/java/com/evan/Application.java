package com.evan;

import com.evan.controller.BookController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        BookController bookController = context.getBean(BookController.class);
        System.out.println(bookController);//com.evan.controller.BookController@4c1bdcc2
        String bookName = bookController.getBookName();
        System.out.println(bookName);//Times
    }
}
