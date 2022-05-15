package com.xwz.fullstack.exception;

import cn.dev33.satoken.exception.*;
import cn.dev33.satoken.stp.StpUtil;
import com.xwz.fullstack.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public Result<?> handlerExceptions(Exception e, HttpServletRequest request, HttpServletResponse response) {

        log.info("全局异常(API)---------------");
        e.printStackTrace();
        // 不同异常返回不同状态码
        if (e instanceof NotLoginException) {               // 如果是未登录异常
            NotLoginException ee = (NotLoginException) e;
            return Result.error("500","请登录");
        } else if (e instanceof NotRoleException) {         // 如果是角色异常
            NotRoleException ee = (NotRoleException) e;
            return Result.error("500","角色异常");
        } else if (e instanceof NotPermissionException) {   // 如果是权限异常
            NotPermissionException ee = (NotPermissionException) e;
            return Result.error("500","权限异常");
        } else if (e instanceof DisableLoginException) {    // 如果是被封禁异常
            DisableLoginException ee = (DisableLoginException) e;
            return Result.error("500","被封禁");
        } else if (e instanceof NotSafeException) {         // 如果是二级认证
            NotSafeException ee = (NotSafeException) e;
            log.info("二级认证异常：" + ee.getMessage());
            StpUtil.openSafe(120);
            return Result.error("500","二级认证错误");
        }else if (e instanceof CustomException) {
            return Result.error(((CustomException) e).getCode(),((CustomException) e).getMsg());
        }else if(e instanceof MethodArgumentNotValidException) {
            List<Map<String, String>> list = new ArrayList<>();
            for (ObjectError objectError : ((MethodArgumentNotValidException) e).getAllErrors()) {
                Map<String, String> map = new HashMap<>();
                if (objectError instanceof FieldError) {
                    FieldError fieldError = (FieldError) objectError;
                    map.put("field", fieldError.getField());
                    map.put("message", fieldError.getDefaultMessage());
                } else {
                    map.put("field", objectError.getObjectName());
                    map.put("message", objectError.getDefaultMessage());
                }
                list.add(map);
            }
            return Result.error("403", String.valueOf(list));
        }else {
            return Result.error("500",e.getMessage());
        }



    }


}
