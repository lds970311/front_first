// Author : evan lee
// Time ： 2022-01-19  0:43
// FILENAME : FirstServlet.java
// STATEMENT: 

package com.evan.web.servlet;

import javax.servlet.*;
import java.io.IOException;

public class FirstServlet implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Hello Servlet");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
