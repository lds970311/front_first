package com.hmdp.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hmdp.dto.LoginFormDTO;
import com.hmdp.dto.Result;
import com.hmdp.dto.UserDTO;
import com.hmdp.entity.User;
import com.hmdp.mapper.UserMapper;
import com.hmdp.service.IUserService;
import com.hmdp.utils.RegexUtils;
import com.hmdp.utils.SystemConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;


@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public Result sendCode(String phone, HttpSession session) {
        //校验手机号
        if (RegexUtils.isPhoneInvalid(phone)) {
            return Result.fail("手机号格式错误!,请重新输入!");
        }
        //符合,生成验证码
        String numbers = RandomUtil.randomNumbers(6);
        //保存验证码
        session.setAttribute("code", numbers);
        //发送验证码
        log.debug("verifyCode: {}", numbers);
        return Result.ok("验证码发送成功!");
    }

    @Override
    public Result login(LoginFormDTO loginForm, HttpSession session) {
        //校验手机号
        if (RegexUtils.isPhoneInvalid(loginForm.getPhone())) {
            return Result.fail("手机号格式错误!,请重新输入!");
        }
        //校验验证码
        Object code = session.getAttribute("code");
        if (code == null || !code.equals(loginForm.getCode())) {
            return Result.fail("验证码错误!");
        }
        //查询用户
        User user = this.query().eq("phone", loginForm.getPhone()).one();
        //不存在,则创建
        if (user == null) {
            user = this.createUserWithPhone(loginForm.getPhone());
        }

        //保存用户信息到session
        session.setAttribute("currentUser", BeanUtil.copyProperties(user, UserDTO.class));
        return Result.ok("用户登录成功!");
    }

    private User createUserWithPhone(String phone) {
        User user = new User();
        user.setPhone(phone);
        user.setNickName(RandomUtil.randomString(SystemConstants.USER_NICK_NAME_PREFIX, 8));
        this.save(user);
        return user;
    }
}
