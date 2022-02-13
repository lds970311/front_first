// Author : evan lee
// Time ： 2022-02-13  12:53
// FILENAME : BookController.java
// STATEMENT: 

package com.evan.controller;

import com.evan.configuration.BootDatasource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("/books")
public class BookController {

    //获取配置文件中的全部属性
    @Resource
    private Environment environment;

    //注入依赖
    @Resource
    private BootDatasource bootDatasource;

    @GetMapping("/new")
    public String getBookName() {
        return "Times";
    }

    @GetMapping("/env")
    public String getEnvironment() {
        return "port" + environment.getProperty("server.port") + "  image: " + environment.getProperty("spring.banner.image.location");
    }

    @GetMapping("/datasource")
    public BootDatasource getDataSource() {
        return bootDatasource;
    }
}
