// Author : evan lee
// Time ： 2022-02-04  23:37
// FILENAME : HelloController.java
// STATEMENT: 

package com.evan.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("/")
    public String index() {
        //返回视图名称,去掉前缀和后缀
        return "index";
    }

    @RequestMapping("/target")
    public String target() {
        return "target";
    }

    @RequestMapping("/movie/{category}/{actor}")
    public String getMovie(@PathVariable("category") String category, @PathVariable("actor") String actor) {
        System.out.printf("%s %s \n", category, actor);
        return "index";
    }
}
