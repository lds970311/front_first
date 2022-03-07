package com.evan.note.servlet;

import com.evan.note.pojo.User;
import com.evan.note.service.UserService;
import com.evan.note.service.impl.UserServiceImpl;
import com.evan.note.vo.ResultInfo;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UserServlet", value = "/UserServlet")
@Slf4j
@MultipartConfig
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
            case "logout":
                this.userLogOut(req, resp);
                break;
            case "userCenter":
                //进入个人中心
                this.userCenter(req, resp);
                break;
            case "typeAdmin":
                this.typeAdmin(req, resp);
                break;
            case "checkNick":
                this.checkNick(req, resp);
                break;
            case "saveUserInfo":
                this.saveUserInfo(req, resp);
                break;
            case "list":
                this.list(req, resp);
                break;
            case "register":
                this.register(req, resp);
                break;
            case "userRegister":
                this.userRegister(req, resp);
                break;
            default:
                log.warn("request not found!");
        }
    }

    /**
     * 用户注册
     *
     * @param req
     * @param resp
     */
    private void userRegister(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        ResultInfo<User> resultInfo = userService.register(userName, password);
        if (resultInfo.getCode() == 1) {
            //成功
            resp.sendRedirect("login.jsp");
        } else {
            //注册失败,回显数据
            req.setAttribute("result", resultInfo);
            req.getRequestDispatcher("register.jsp").forward(req, resp);
        }
    }

    private void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("register.jsp").forward(req, resp);
    }

    private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("changePage", "list.jsp");
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    /**
     * 保存用户信息
     *
     * @param req
     * @param resp
     */
    private void saveUserInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ResultInfo<User> resultInfo = userService.saveUserInfo(req);
        req.setAttribute("resultInfo", resultInfo);
        req.getRequestDispatcher("UserServlet?actionName=userCenter").forward(req, resp);
    }

    /**
     * 查看昵称是否被占用
     *
     * @param req
     * @param resp
     */
    private void checkNick(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String nickName = req.getParameter("nickName");
        User user = (User) req.getSession().getAttribute("user");
        Integer code = userService.checkNickName(nickName, user.getUserId());
        PrintWriter writer = resp.getWriter();
        writer.write(code + "");
        writer.close();
    }

    /**
     * 进入类型管理
     *
     * @param req
     * @param resp
     */
    private void typeAdmin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("changePage", "type.jsp");
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    /**
     * 进入个人中心
     * 1. 设置首页动态包含的页面值
     * 2. 请求转发跳转到index.jsp
     *
     * @param req
     * @param resp
     */
    private void userCenter(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("changePage", "personal_center.jsp");
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    private void userLogOut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //清除cookie和session
        HttpSession session = req.getSession();
        session.invalidate();
        Cookie cookie = new Cookie("user", null);
        cookie.setMaxAge(0);
        resp.addCookie(cookie);
        resp.sendRedirect("login.jsp");
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
            resp.sendRedirect("IndexServlet");
        }
    }

}
