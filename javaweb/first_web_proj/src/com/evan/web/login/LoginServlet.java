// Author : evan lee
// Time ： 2022-01-19  22:08
// FILENAME : LoginServlet.java
// STATEMENT: 

package com.evan.web.login;

import com.evan.web.beans.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("123123");
        //设置编码
        req.setCharacterEncoding("UTF-8");
        //获取用户名 密码
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        UserInfo user = UserDao.getUser(username, password);
        if (user != null) {
            System.out.println(user);
            req.setAttribute("user", user);
            req.getRequestDispatcher("/success").forward(req, resp);
        } else {
            req.getRequestDispatcher("/fail").forward(req, resp);
        }
    }
}
