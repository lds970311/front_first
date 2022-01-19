// Author : evan lee
// Time ： 2022-01-20  0:02
// FILENAME : RedirectServlet.java
// STATEMENT: 

package com.evan.web.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/go_souhu")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("redirecting...");
        resp.sendRedirect("https://www.baidu.com");
    }
}
