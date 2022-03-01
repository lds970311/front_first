// Author : evan lee
// Time ： 2022-02-28  22:14
// FILENAME : UserServiceImpl.java
// STATEMENT: 

package com.evan.note.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.evan.note.dao.UserDao;
import com.evan.note.dao.iml.UserDaoImpl;
import com.evan.note.pojo.User;
import com.evan.note.service.UserService;
import com.evan.note.vo.ResultInfo;

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
}
