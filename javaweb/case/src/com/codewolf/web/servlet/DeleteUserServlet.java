// Author : evan lee
// Time ： 2022-01-21  22:32
// FILENAME : DeleteUserServlet.java
// STATEMENT: 

package com.codewolf.web.servlet;

import com.codewolf.service.UserService;
import com.codewolf.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delUser")
public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        String id = req.getParameter("id");
        userService.deleteById(id);
        req.getRequestDispatcher("/userListServlet").forward(req, resp);
    }
}
