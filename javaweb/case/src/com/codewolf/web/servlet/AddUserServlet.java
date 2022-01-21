// Author : evan lee
// Time ： 2022-01-21  21:26
// FILENAME : AddUserServlet.java
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

@WebServlet("/addUser")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.设置编码
        req.setCharacterEncoding("utf-8");
        //2. 获取请求参数
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        Integer age = Integer.valueOf(req.getParameter("age"));
        String address = req.getParameter("address");
        String qq = req.getParameter("qq");
        String email = req.getParameter("email");
        User user = new User(null, name, sex, address, qq, email, age);
        UserService userService = new UserServiceImpl();
        userService.insert(user);
        req.getRequestDispatcher("/userListServlet").forward(req, resp);
    }
}
