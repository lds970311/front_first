// Author : evan lee
// Time ： 2022-01-19  19:58
// FILENAME : ReceiverServlet.java
// STATEMENT: 

package com.evan.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/receiver")
public class ReceiverServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("-------------------------------");
        System.out.println("receiver servlet");
        System.out.println(req.getAttribute("msg"));
        System.out.println(req.getAttribute("score"));
    }
}
