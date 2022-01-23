// Author : evan lee
// Time ： 2022-01-22  16:40
// FILENAME : DeleteSelectedServlet.java
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

/**
 * 选中删除的servlet
 */
@WebServlet("/deleteSelected")
public class DeleteSelectedServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] ids = req.getParameterValues("id");
        UserService userService = new UserServiceImpl();
        for (String id : ids) {
            userService.deleteById(id);
        }
        req.getRequestDispatcher("/userListServlet").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}
