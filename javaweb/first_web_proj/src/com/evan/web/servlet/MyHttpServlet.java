// Author : evan lee
// Time ： 2022-01-19  16:26
// FILENAME : MyHttpServlet.java
// STATEMENT: 

package com.evan.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/http")
public class MyHttpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("method" + req.getMethod()); //methodGET
        System.out.println("contextPath: " + req.getContextPath()); //contextPath: /first_web_proj
        System.out.println("ServletPath:" + req.getServletPath());//ServletPath:/http
        System.out.println("Protocal:" + req.getProtocol()); //Protocal:HTTP/1.1
        System.out.println("URL:" + req.getRequestURL()); //URL:http://localhost:8081/first_web_proj/http
        //获取请求头数据
        System.out.println("--------------------------------------");
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            System.out.println(headerNames.nextElement());
        }
        /*
            host
            user-agent
            accept
            accept-language
            accept-encoding
            connection
            cookie
            upgrade-insecure-requests
            sec-fetch-dest
            sec-fetch-mode
            sec-fetch-site
            sec-fetch-user
         */
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("do post3123123");
        //解决乱码
        req.setCharacterEncoding("UTF-8");
        //获取请求体数据
        BufferedReader reader = req.getReader();
        String line = null;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }
}
