// Author : evan lee
// Time ： 2022-01-20  0:59
// FILENAME : WriterServlet.java
// STATEMENT: 测试响应

package com.evan.web.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/write_test")
public class WriterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("content-type", "text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.write("<h2>Hello1131232是我</h2>");
    }
}
