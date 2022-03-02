package com.evan.note.filters;

import cn.hutool.core.util.StrUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 过滤所有资源
 */
@WebFilter(filterName = "EncodingFilter", value = "/*")
public class EncodingFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        req.setCharacterEncoding("utf-8");
        //判断请求类型,如果是get请求, 判断服务器版本
        if ("GET".equalsIgnoreCase(req.getMethod())) {
            //获取版本
            String serverInfo = request.getServletContext().getServerInfo();
            String version = serverInfo.substring(serverInfo.lastIndexOf("/") + 1, serverInfo.indexOf("."));
            //判断是否是7一下
            if (Integer.parseInt(version) < 8) {
                MyWrapper myWrapper = new MyWrapper(req);
                chain.doFilter(myWrapper, resp);
            }
        }
        chain.doFilter(request, response);
    }

    /**
     * 1. 定义内部类 （类的本质是request对象）
     * 2. 继承 HttpServletRequestWrapper包装类
     * 3. 重写getarameterP()方法
     */
    class MyWrapper extends HttpServletRequestWrapper {

        // 定义成员变量 HttpServletRequest对象 （提升构造器中request对象的作用域）
        private final HttpServletRequest request;

        public MyWrapper(HttpServletRequest request) {
            super(request);
            this.request = request;
        }

        @Override
        public String getParameter(String name) {
            String value = request.getParameter(name);
            //判断参数
            if (StrUtil.isBlank(value)) {
                return value;
            }
            value = new String(value.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
            return value;
        }
    }
}
