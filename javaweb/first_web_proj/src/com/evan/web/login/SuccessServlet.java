// Author : evan lee
// Time ： 2022-01-19  22:28
// FILENAME : SuccessServlet.java
// STATEMENT: 

package com.evan.web.login;

import com.evan.web.beans.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/success")
public class SuccessServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
//        UserInfo user = (UserInfo) req.getAttribute("user");
        UserInfo user = (UserInfo) req.getSession().getAttribute("user");
        resp.getWriter().write(user.getUser() + "登录成功");
    }
}
