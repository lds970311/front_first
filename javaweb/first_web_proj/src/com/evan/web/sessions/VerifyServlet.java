// Author : evan lee
// Time ： 2022-01-20  21:39
// FILENAME : VerifyServlet.java
// STATEMENT: 

package com.evan.web.sessions;

import com.evan.web.beans.UserInfo;
import com.evan.web.login.ConnectionCreator;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/check_login")
public class VerifyServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("1111");
        //设置request编码
        req.setCharacterEncoding("utf-8");
        //获取参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String checkCode = req.getParameter("checkCode");
        //校验验证码是否正确
        String checkCode_session = (String) req.getSession().getAttribute("checkCode_session");
        //删除验证码
        req.getSession().removeAttribute("checkCode_session");
        if (checkCode.equalsIgnoreCase(checkCode_session)) {
            //验证码正确
            Connection connection = ConnectionCreator.getDBConnection();
            QueryRunner queryRunner = new QueryRunner();
            BeanHandler<UserInfo> handler = new BeanHandler<>(UserInfo.class);
            String sql = "select user, password from my_jdbc.user_table where user = ? and password = ?";
            try {
                UserInfo userInfo = queryRunner.query(connection, sql, handler, username, password);
                if (userInfo != null) {
                    System.out.println("success");
                    req.getSession().setAttribute("user", userInfo);
                    req.getRequestDispatcher("/success").forward(req, resp);
                } else {
                    //用户名密码错误
                    req.setAttribute("u_error", "用户名或密码错误");
                    req.getRequestDispatcher("/jsp/login.jsp").forward(req, resp);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            //验证码错误
            System.out.println("验证码错误");
            req.setAttribute("v_error", "验证码错误");
            req.getRequestDispatcher("/jsp/login.jsp").forward(req, resp);
        }
    }
}
