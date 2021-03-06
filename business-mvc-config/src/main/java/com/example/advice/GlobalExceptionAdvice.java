package com.example.advice;


import lombok.extern.slf4j.Slf4j;
import org.example.vo.CommonResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/*
*
* <h2>全局异常捕获处理</h2>
*
* */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionAdvice {

    //异常处理方法
    @ExceptionHandler(value = Exception.class)
    public CommonResponse<String> handlerCommonException(
        HttpServletRequest req,Exception ex
    ){
        CommonResponse<String> response = new CommonResponse<>(
                -1,"business error"
        );
        response.setData(ex.getMessage());
        log.error("service has error: [{}]",ex.getMessage(),ex);
        return response;
    }
}
