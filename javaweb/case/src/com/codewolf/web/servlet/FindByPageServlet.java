// Author : evan lee
// Time ： 2022-01-22  18:46
// FILENAME : FindByPageServlet.java
// STATEMENT: 

package com.codewolf.web.servlet;

import com.codewolf.domain.PageBean;
import com.codewolf.domain.User;
import com.codewolf.service.UserService;
import com.codewolf.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/findByPage")
public class FindByPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String currentPage = req.getParameter("currentPage");
        String rows = req.getParameter("rows"); //当前页的记录条数
        if (currentPage == null || "".equals(currentPage)) {
            currentPage = "1";
        }
        if (rows == null || "".equals(rows)) {
            rows = "5";
        }

        Map<String, String[]> condition = req.getParameterMap();
        //2. 调用service查询
        UserService userService = new UserServiceImpl();
        PageBean<User> page = userService.findUserByPage(currentPage, rows, condition);
        req.setAttribute("page", page);
        req.setAttribute("condition", condition);//将查询条件存入request
        req.getRequestDispatcher("/views/list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        this.doGet(req, resp);
    }
}
