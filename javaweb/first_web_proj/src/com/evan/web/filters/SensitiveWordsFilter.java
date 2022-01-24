package com.evan.web.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * 敏感词过滤器
 */
@WebFilter(filterName = "SensitiveWordsFilter",
        dispatcherTypes = DispatcherType.REQUEST,
        value = "/*")
public class SensitiveWordsFilter implements Filter {
    private List<String> words = new ArrayList<>();

    public void init(FilterConfig config) throws ServletException {
        //加载敏感词文件
        String realPath = config.getServletContext().getRealPath("WEB-INF/classes/resources/sensitiveWords.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(realPath));) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                words.add(new String(line.getBytes("GBK")));
            }
            System.out.println(words);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //1.创建代理对象,增强getParameter方法
        ServletRequest proxyRequest = (ServletRequest) Proxy.newProxyInstance(request.getClass().getClassLoader(), request.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if ("getParameter".equals(method.getName())) {
                    //增强
                    String value = (String) method.invoke(request, args);
                    if (value != null) {
                        for (String word : words) {
                            if (value.contains(word)) {
                                value = value.replaceAll(word, "***");
                            }
                        }
                    }
                    return value;
                }
                return method.invoke(request, args);
            }
        });
        //2.放行
        chain.doFilter(proxyRequest, response);
    }
}
