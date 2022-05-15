package com.xwz.fullstack.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.xwz.fullstack.common.Result;
import com.xwz.fullstack.entity.User;
import com.xwz.fullstack.entity.dto.LoginDTO;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author XiaoWenzhuo
 * @since 2022-04-19
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @ApiOperation("用户列表")
    @GetMapping("/list")
    public Result<User> list() {
        return Result.success(new User());
    }


    @ApiOperation("登录返回token")
    @PostMapping("/login")
    public Result<?> login(@RequestBody LoginDTO loginDTO){
        if("zhang".equals(loginDTO.getUsername()) && "123456".equals(loginDTO.getPassword())) {
            StpUtil.login(10001);
            String tokenName = StpUtil.getTokenName();
            Map<String, Object> map =new HashMap<>();
            map.put("token", StpUtil.getTokenValue());
            return Result.success(map);
        }
        return Result.error("500","用户名或密码错误");
    }

    @ApiOperation("根据token查询用户信息")
    @GetMapping("/info")
    public Result<?> info(@RequestParam String token){
        log.info("token:{}",token);
        Object loginId = StpUtil.getLoginId();
        Map<String, Object> map =new HashMap<>();
        map.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        map.put("loginId", loginId);
        map.put("roles", Arrays.asList("user"));
        return Result.success(map);
    }

    @ApiOperation("退出登录")
    @GetMapping("/logout")
    public Result<?> logout(){
        log.info("退出登录"+StpUtil.getLoginId());
        StpUtil.logout();
        return Result.success();
    }
}
