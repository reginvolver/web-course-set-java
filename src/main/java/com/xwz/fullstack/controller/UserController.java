package com.xwz.fullstack.controller;

import com.xwz.fullstack.common.Result;
import com.xwz.fullstack.entity.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author XiaoWenzhuo
 * @since 2022-04-19
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @ApiOperation("用户列表")
    @RequestMapping("/list")
    public Result<User> list() {
        return Result.success(new User());
    }
}
