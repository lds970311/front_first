// Author : evan lee
// Time ： 2022-02-16  21:00
// FILENAME : BookController.java
// STATEMENT: 

package com.evan.boot_ssmp.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.evan.boot_ssmp.controller.utils.Result;
import com.evan.boot_ssmp.domain.Book;
import com.evan.boot_ssmp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public Result listAll() {
        Result result = new Result();
        result.setCode(HttpStatus.OK);
        result.setData(bookService.getAll());
        return result;
    }

    @GetMapping("{id}")
    public Result getOne(@PathVariable Integer id) {
        Result result = new Result();
        Book byId = bookService.getById(id);
        result.setData(byId);
        result.setCode(HttpStatus.OK);
        return result;
    }

    @PostMapping
    public Result addBook(@RequestBody Book book) {
        Result result = new Result();
        result.setCode(HttpStatus.OK);
        result.setData(bookService.save(book));
        return result;
    }

    @PutMapping
    public Result updateBook(@RequestBody Book book) {
        Result result = new Result();
        result.setCode(HttpStatus.OK);
        result.setData(bookService.update(book));
        return result;
    }

    @DeleteMapping("{id}")
    public Result deleteBook(@PathVariable Integer id) {
        Result result = new Result();
        result.setCode(HttpStatus.OK);
        result.setData(bookService.delete(id));
        return result;
    }

    @PostMapping("batchDelete")
    public Result batchDelete(@RequestParam String ids) {
        Result result = new Result();
        System.out.println(ids);
        result.setCode(HttpStatus.OK);
        result.setData(this.bookService.batchDelete(ids));
        return result;
    }

    @GetMapping("byPage")
    public Result getByPage(@RequestParam Integer pageSize, Integer pageNum, String title, String author, Double price) {
        System.out.println("test host deploy");
        System.out.println("test host deploy");
        System.out.println("test host deploy");
        Result result = new Result();
        System.out.println("pageSize= " + pageSize + " pageNum= " + pageNum);
        IPage<Book> page = this.bookService.getByPage(pageNum, pageSize, title, author, price);
        //如果当前页码>总页码, 重新执行查询操作,使用最大页码最为当期页
        if (pageNum > page.getPages()) {
            page = this.bookService.getByPage((int) page.getPages(), pageSize, title, author, price);
        }
        result.setCode(HttpStatus.OK);
        result.setData(page);
        return result;
    }
}
