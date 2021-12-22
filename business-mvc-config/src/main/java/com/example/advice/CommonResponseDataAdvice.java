package com.example.advice;

import com.example.annotation.IgnoreResponseAdvice;
import org.example.vo.CommonResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 *实现统一响应
 */
@RestControllerAdvice(value = "org.example")
public class CommonResponseDataAdvice implements ResponseBodyAdvice<Object> {

    //判断响应是否需要被包装
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        if (returnType.getDeclaringClass()
                .isAnnotationPresent(IgnoreResponseAdvice.class)){
            return false;
        }
        if (returnType.getMethod().isAnnotationPresent(IgnoreResponseAdvice.class)){
            return false;
        }
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body,
                                  MethodParameter returnType,
                                  MediaType selectedContentType,
                                  Class selectedConverterType,
                                  ServerHttpRequest serverHttpRequest,
                                  ServerHttpResponse serverHttpResponse) {
        //定义最终返回对
        CommonResponse<Object> response = new CommonResponse<>(0,"");

        if (null == body){
            return false;
        } else if(body instanceof CommonResponse){
            response = (CommonResponse<Object>) body ;
        } else {
            response.setData(body);
        }
        return response;
    }
}
