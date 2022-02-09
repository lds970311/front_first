// Author : evan lee
// Time ： 2022-02-09  17:57
// FILENAME : ExceptionController.java
// STATEMENT: 

package com.evan.mvc.exceptionhandler;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice //将当前类标识为异常处理的组件
public class ExceptionController {

    @ExceptionHandler(ArithmeticException.class)
    //ex表示当前请求处理中出现的异常对象
    public String handleArithmeticException(Exception ex, Model model) {
        model.addAttribute("ex", ex);
        return "error";
    }
}
