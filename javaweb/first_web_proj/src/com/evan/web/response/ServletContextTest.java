// Author : evan lee
// Time ： 2022-01-20  15:27
// FILENAME : ServletContextTest.java
// STATEMENT: 

package com.evan.web.response;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ctx")
public class ServletContextTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext ctx = this.getServletContext();
        String fileName = "a.jpg";
        String mimeType = ctx.getMimeType(fileName);
        System.out.println(mimeType); //image/jpeg
        resp.getWriter().write(mimeType);
        System.out.println("123");
    }
}
