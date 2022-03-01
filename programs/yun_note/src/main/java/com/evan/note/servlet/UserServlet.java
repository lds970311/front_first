package com.evan.note.servlet;

import com.evan.note.pojo.User;
import com.evan.note.service.UserService;
import com.evan.note.service.impl.UserServiceImpl;
import com.evan.note.vo.ResultInfo;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "UserServlet", value = "/UserServlet")
@Slf4j
public class UserServlet extends HttpServlet {
    private final UserService userService = new UserServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接受用户行为
        String actionName = req.getParameter("actionName");
        switch (actionName) {
            case "login":
                this.userLogin(req, resp);
                break;
            default:
                log.warn("request not found!");
        }
    }

    /**
     * 用户登录
     *
     * @param req
     * @param resp
     */
    private void userLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取参数 （姓名、密码）
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        String isChecked = req.getParameter("isChecked");
        ResultInfo<User> resultInfo = userService.userLogin(userName, password);
        //判断是否登录成功
        if (resultInfo.getCode() == 0) {
            //请求转发到登录页
            req.setAttribute("resultInfo", resultInfo);
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        } else {
            //成功,  将用户信息存到session作用域中
            HttpSession session = req.getSession();
            session.setAttribute("user", resultInfo.getResult());
            //判断是否记住密码
            Cookie cookie;
            if ("".equals(isChecked)) {
                //记住密码
                cookie = new Cookie("user", userName + "-" + password);
                cookie.setMaxAge(60 * 60 * 7 * 24);
                cookie.setHttpOnly(true);
            } else {
                //不记住
                cookie = new Cookie("user", null);
                cookie.setHttpOnly(true);
                cookie.setMaxAge(0);
            }
            resp.addCookie(cookie);
            resp.sendRedirect("index.jsp");
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
