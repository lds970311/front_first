// Author : evan lee
// Time ： 2022-05-15  23:56
// FILENAME : LoginInterceprot.java
// STATEMENT: 

package com.hmdp.interceptor;

import com.hmdp.dto.UserDTO;
import com.hmdp.service.utils.UserHolder;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //判断是否需要拦截
        UserDTO user = UserHolder.getUser();
        if (user == null) {
            response.setStatus(401);
            return false;
        }
        return true;
    }
}
