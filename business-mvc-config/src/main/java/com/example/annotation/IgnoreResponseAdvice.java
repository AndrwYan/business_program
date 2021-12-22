package com.example.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
*
* 为何需要注解？
* <h1>主要是忽略标识接口不需要返回统一的标识</h1>
* */
@Target({ElementType.TYPE,ElementType.METHOD})//元注解
@Retention(RetentionPolicy.RUNTIME)
public @interface IgnoreResponseAdvice {

}
