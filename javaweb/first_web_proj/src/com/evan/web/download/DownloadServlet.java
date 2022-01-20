// Author : evan lee
// Time ： 2022-01-20  15:51
// FILENAME : DownloadServlet.java
// STATEMENT: 

package com.evan.web.download;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取下载的文件名称
        ServletContext context = this.getServletContext();
        String path = context.getRealPath("imgs/2.jpg");
        //指定响应头
        resp.setContentType(context.getMimeType("imgs/2.jpg"));
        resp.setHeader("content-disposition", "attachment;filename=imgs/2.jpg");
        //resp.getWriter().write(path);
        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(path));
        byte[] buf = new byte[256];
        int len = 0;
        ServletOutputStream outputStream = resp.getOutputStream();
        while ((len = inputStream.read(buf)) != -1) {
            outputStream.write(buf, 0, len);
        }

        inputStream.close();
    }
}
