package com.evan.note.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

@WebFilter(filterName = "LoginAccessFilter",
        value = "/*")
public class LoginAccessFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        //1. 得到访问的资源路径
        String path = req.getRequestURI();
        if (path.contains("login.jsp") || path.contains("/static")) {
            chain.doFilter(req, resp);
            return;
        }
        //指定行为,放行
        if (path.contains("User")) {
            //得到用户行为
            String actionName = req.getParameter("actionName");
            if ("login".equalsIgnoreCase(actionName)) {
                chain.doFilter(req, resp);
                return;
            }
        }

        //判断登录状态,如果不是,则返回登录页
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");
        if (user != null) {
            chain.doFilter(req, resp);
            return;
        }

        //免登陆
        Cookie[] cookies = req.getCookies();
        Cookie cookie = this.loginFree(cookies);
        if (cookie != null) {
            this.validateCookie(cookie, req, resp);
            return;
        }

        resp.sendRedirect("login.jsp");
    }

    private void validateCookie(Cookie cookie, HttpServletRequest req, HttpServletResponse resp) {
        Optional.ofNullable(cookie)
                .ifPresent(cookie1 -> {
                    String user = cookie1.getValue();
                    String[] split = user.split("-");
                    String userName = split[0];
                    String password = split[1];
                    try {
                        req.getRequestDispatcher("UserServlet?actionName=login&userName=" + userName + "&password=" + password)
                                .forward(req, resp);
                    } catch (ServletException | IOException e) {
                        e.printStackTrace();
                    }
                });
    }

    private Cookie loginFree(Cookie[] cookies) {
        for (Cookie cookie : cookies) {
            if ("user".equals(cookie.getName())) {
                return cookie;
            }
        }
        return null;
    }
}
