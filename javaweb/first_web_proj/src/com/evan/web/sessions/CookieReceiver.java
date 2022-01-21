// Author : evan lee
// Time ： 2022-01-20  18:21
// FILENAME : CookieReceiver.java
// STATEMENT: 

package com.evan.web.sessions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/receivecookie")
public class CookieReceiver extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            System.out.println(cookie.getName() + cookie.getValue() + cookie.getDomain() + cookie.getMaxAge());
        }
    }
}
