// Author : evan lee
// Time ： 2022-05-18  20:46
// FILENAME : RefreshTokenInterceptor.java
// STATEMENT: 

package com.hmdp.interceptor;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.hmdp.dto.UserDTO;
import com.hmdp.service.utils.RedisConstants;
import com.hmdp.service.utils.UserHolder;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class RefreshTokenInterceptor implements HandlerInterceptor {
    private StringRedisTemplate stringRedisTemplate;

    public RefreshTokenInterceptor(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("authorization");
        //HttpSession session = request.getSession();
        if (StrUtil.isBlank(token)) {
            return true;
        }

        //UserDTO user = (UserDTO) session.getAttribute("currentUser");
        Map<Object, Object> entries = stringRedisTemplate.opsForHash().entries(RedisConstants.LOGIN_USER_KEY + token);
        if (entries.isEmpty()) {
            return true;
        }
        UserDTO user = BeanUtil.toBean(entries, UserDTO.class);
        //基于token获取redis中的用户
        if (user == null) {
            response.setStatus(401);
            return false;
        }
        //存在,保存用户到ThreadLocal
        UserHolder.saveUser(user);
        stringRedisTemplate.expire(RedisConstants.LOGIN_USER_KEY + token, 30, TimeUnit.MINUTES);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        UserHolder.removeUser();
    }
}
