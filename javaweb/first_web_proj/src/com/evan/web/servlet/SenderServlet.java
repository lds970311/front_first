// Author : evan lee
// Time ： 2022-01-19  19:58
// FILENAME : SenderServlet.java
// STATEMENT: 用于转发请求的servlet

package com.evan.web.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/sender")
public class SenderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("sender servlet");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/receiver");
        req.setAttribute("msg", "hello");
        req.setAttribute("score", 100);
        //转发请求
        dispatcher.forward(req, resp);
    }
}
