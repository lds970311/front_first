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
        //设置编码
        req.setCharacterEncoding("utf-8");

        UserService userService = new UserServiceImpl();
        //获取参数
        Integer id = Integer.valueOf(req.getParameter("id"));
        String name = req.getParameter("name");
        Integer age = Integer.valueOf(req.getParameter("age"));
        String gender = req.getParameter("sex");
        String address = req.getParameter("address");
        String qq = req.getParameter("qq");
        String email = req.getParameter("email");
        User user = new User(id, name, gender, address, qq, email, age);
        userService.updateUser(user);
        req.getRequestDispatcher("/userListServlet").forward(req, resp);
    }
}
