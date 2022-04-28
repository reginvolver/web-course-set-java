package com.xwz.fullstack.exception;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.xwz.fullstack.common.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice(basePackages = "com.xwz.fullstack.controller")
public class GlobalExceptionHandler {

    private static final Log log = LogFactory.get();

    //统一异常处理@ExceptionHandler,主要用于Exception
    @ExceptionHandler(CustomException.class)
    @ResponseBody//返回json串
    public Result<?> customer(HttpServletRequest request, CustomException e) {
        return Result.error(e.getCode(), e.getMsg());
    }

}