// Author : evan lee
// Time ： 2022-02-17  21:16
// FILENAME : ProjectExceptionAdvice.java
// STATEMENT: 

package com.evan.boot_ssmp.controller;

import com.evan.boot_ssmp.controller.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * SpringMVC异常处理器
 */
@RestControllerAdvice
@Slf4j
public class ProjectExceptionAdvice {
    //拦截所有异常性信息
    @ExceptionHandler
    public Result doException(Exception ex) {
        ex.printStackTrace();
        log.error(ex.getMessage());
        return new Result(HttpStatus.BAD_REQUEST, ex.getMessage());
    }
}
