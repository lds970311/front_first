// Author : evan lee
// Time ： 2022-01-20  18:17
// FILENAME : CookieSender.java
// STATEMENT: 

package com.evan.web.sessions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/sendcookie")
public class CookieSender extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("msg", "hello");
        resp.addCookie(cookie);
        resp.addCookie(new Cookie("name", "lucy"));
    }
}
