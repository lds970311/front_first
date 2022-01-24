package com.evan.web.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "ForwardFilter",
        dispatcherTypes = DispatcherType.FORWARD,
        value = "/jsp/*")
public class ForwardFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("ForwardFilter executed");
        chain.doFilter(request, response);
    }
}

