// Author : evan lee
// Time ： 2022-01-21  18:57
// FILENAME : UserListServlet.java
// STATEMENT: 

package com.codewolf.web.servlet;

import com.codewolf.domain.User;
import com.codewolf.service.UserService;
import com.codewolf.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/userListServlet")
public class UserListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        List<User> allUser = userService.findAll();
        System.out.println(allUser);
        //将list存入request域
        req.setAttribute("users", allUser);
        //转发页面
        req.getRequestDispatcher("/views/list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
