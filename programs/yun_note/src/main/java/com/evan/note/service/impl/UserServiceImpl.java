// Author : evan lee
// Time ： 2022-02-28  22:14
// FILENAME : UserServiceImpl.java
// STATEMENT: 

package com.evan.note.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.evan.note.dao.UserDao;
import com.evan.note.dao.impl.UserDaoImpl;
import com.evan.note.pojo.User;
import com.evan.note.service.UserService;
import com.evan.note.vo.ResultInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;

public class UserServiceImpl implements UserService {
    private final UserDao userDao = new UserDaoImpl();


    @Override
    public ResultInfo<User> userLogin(String username, String password) {
        ResultInfo<User> resultInfo = new ResultInfo<>();
        //数据回显,登录失败时,登录信息给前端显示
        User u = new User();
        u.setUname(username);
        u.setUpwd(password);
        //判断参数是否为空
        if (StrUtil.isBlank(username) || StrUtil.isBlank(password)) {
            resultInfo.setCode(0);
            resultInfo.setMessage("用户名和密码不能为空!");
            resultInfo.setResult(u);
            return resultInfo;
        }
        //如果不为空，通过用户名查询用户对象
        User user = userDao.getUserByName(username);
        if (user == null) {
            resultInfo.setCode(0);
            resultInfo.setMessage("该用户名不存在!!");
            resultInfo.setResult(u);
            return resultInfo;
        }
        //如果用户对象不为空，将数据库中查询到的用户对象的密码与前台传递的密码作比较
        if (!user.getUpwd().equals(DigestUtil.md5Hex(password))) {
            resultInfo.setCode(0);
            resultInfo.setMessage("您输入的密码不正确!");
            resultInfo.setResult(u);
            return resultInfo;
        } else {
            resultInfo.setCode(1);
            resultInfo.setMessage("登录成功!");
            resultInfo.setResult(user);
        }
        return resultInfo;
    }

    @Override
    public Integer checkNickName(String nickName, Integer userId) {
        //验证昵称唯一性
        if (StrUtil.isBlank(nickName)) {
            return 0;
        }
        User user = userDao.queryUserByNickName(nickName, userId);
        if (user == null) {
            return 1;
        }
        return 0;
    }

    @Override
    public ResultInfo<User> saveUserInfo(HttpServletRequest req) {
        ResultInfo<User> resultInfo = new ResultInfo<>();
        // 获取参数（昵称、心情）
        String nick = req.getParameter("nick");
        String mood = req.getParameter("mood");
        //判断必填参数非空
        if (StrUtil.isBlank(nick)) {
            resultInfo.setCode(0);
            resultInfo.setMessage("用户昵称不能为空!");
            return resultInfo;
        }
        //从session作用域中获取用户对象
        User user = (User) req.getSession().getAttribute("user");
        user.setNick(nick);
        user.setMood(mood);
        //实现上上传文件
        try {
            Part part = req.getPart("img");
            String head = part.getHeader("Content-Disposition");
            String str = head.substring(head.lastIndexOf("=") + 2, head.length() - 1);
            if (!StrUtil.isBlank(str)) {
                //如果上传了头像,则更新头像
                user.setHead(str);
                String filePath = req.getServletContext().getRealPath("/static/images");
                part.write(filePath + "/" + str);
            }
            System.out.println(str);
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
        int row = userDao.updateUser(user);
        if (row > 0) {
            resultInfo.setCode(1);
            resultInfo.setMessage("更新成功");
            resultInfo.setResult(user);
            req.getSession().setAttribute("user", user);
            return resultInfo;
        }
        resultInfo.setCode(0);
        resultInfo.setMessage("更新失败!");
        return resultInfo;
    }

    @Override
    public ResultInfo<User> register(String userName, String password) {
        ResultInfo<User> resultInfo = new ResultInfo<>();
        if (StrUtil.isEmpty(userName)) {
            resultInfo.setCode(0);
            resultInfo.setMessage("用户名为空,不能注册!");
            User user = new User();
            user.setUname("");
            user.setUpwd("");
            resultInfo.setResult(user);
            return resultInfo;
        }

        if (StrUtil.isBlank(password)) {
            resultInfo.setCode(0);
            resultInfo.setMessage("密码为空,不能注册!");
            User user = new User();
            user.setUname("");
            user.setUpwd("");
            resultInfo.setResult(user);
            return resultInfo;
        }

        //注册用户
        int row = userDao.registerUser(userName, DigestUtil.md5Hex(password));
        if (row == 0) {
            //注册失败
            resultInfo.setCode(0);
            resultInfo.setMessage("注册失败,请稍后重试!");
            User user = new User();
            user.setUname(userName);
            user.setUpwd(password);
            resultInfo.setResult(user);
            return resultInfo;
        }
        //注册成功
        resultInfo.setCode(1);
        resultInfo.setMessage("注册成功");
        return resultInfo;
    }
}
