// AUTHOR: CSR丶SUSE
// TIME : 2022-02-06  20:09
// FILENAME: ScopeController.java
// TOOLS : INTELLIJ IDEA
// STATEMENT: 


package com.evan.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/scope")
public class ScopeController {

    @GetMapping("/name")
    public String sessionScope(HttpServletRequest request, HttpSession session) {
        ServletContext context = request.getServletContext();
        context.setAttribute("name", "张三");
        session.setAttribute("age", 21);
        return "scope";
    }

}
