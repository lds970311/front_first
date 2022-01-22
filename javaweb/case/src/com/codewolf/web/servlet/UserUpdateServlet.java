// Author : evan lee
// Time ： 2022-01-22  0:51
// FILENAME : UserUpdateServlet.java
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

@WebServlet("/updateUser")
public class UserUpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        User user = new User();
        userService.updateUser(user);
        req.getRequestDispatcher("/userListServlet").forward(req, resp);
    }
}
