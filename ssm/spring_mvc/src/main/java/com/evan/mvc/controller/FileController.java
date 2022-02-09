// Author : evan lee
// Time ： 2022-02-08  23:18
// FILENAME : FileController.java
// STATEMENT: 

package com.evan.mvc.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Controller
@RequestMapping("/file")
public class FileController {

    @RequestMapping("/download")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException {
        //获取ServletContext对象
        ServletContext servletContext = session.getServletContext();
        //获取服务器中文件的真实路径
        String realPath = servletContext.getRealPath("/static/imgs/1.jpg");
        //创建输入流
        InputStream is = new FileInputStream(realPath);
        //创建字节数组
        byte[] bytes = new byte[is.available()];
        //将流读到字节数组中
        is.read(bytes);
        //创建HttpHeaders对象设置响应头信息
        MultiValueMap<String, String> headers = new HttpHeaders();
        //设置要下载方式以及下载文件的名字
        headers.add("Content-Disposition", "attachment;filename=1.jpg");
        //设置响应状态码
        HttpStatus statusCode = HttpStatus.OK;
        //创建ResponseEntity对象
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers, statusCode);
        //关闭输入流
        is.close();
        return responseEntity;
    }

    @PostMapping("/upload")
    @ResponseBody
    public String uploadFile(MultipartFile photo, HttpSession session) throws IOException {
        //获取上传的文件的文件名
        String fileName = photo.getOriginalFilename();
        System.out.println(fileName);
        //处理文件重名问题
        String hzName = fileName.substring(fileName.lastIndexOf("."));
        fileName = UUID.randomUUID() + hzName;
        //获取服务器中photo目录的路径
        ServletContext servletContext = session.getServletContext();
        String photoPath = servletContext.getRealPath("/static/imgs");
        File file = new File(photoPath);
        if (!file.exists()) {
            boolean mkdir = file.mkdir();
            if (!mkdir) {
                System.out.println("mkdir failed");
            }
        }
        String finalPath = photoPath + File.separator + fileName;
        //实现上传功能
        photo.transferTo(new File(finalPath));
        return "success";
    }
}
