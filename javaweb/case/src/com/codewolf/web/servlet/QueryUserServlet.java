// Author : evan lee
// Time ： 2022-01-21  23:03
// FILENAME : QueryUserServlet.java
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

/**
 * 用户查询的servlet
 */
@WebServlet("/queryUser")
public class QueryUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        String id = req.getParameter("id");
        User currUser = userService.findUserById(id);
        req.setAttribute("currUser", currUser);
        req.getRequestDispatcher("/views/update.jsp").forward(req, resp);
    }
}
