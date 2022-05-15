package com.xwz.fullstack.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.crypto.digest.BCrypt;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xwz.fullstack.common.Result;
import com.xwz.fullstack.entity.User;
import com.xwz.fullstack.entity.dto.LoginDTO;
import com.xwz.fullstack.entity.dto.RegisterDTO;
import com.xwz.fullstack.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
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
@SaCheckLogin
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @ApiOperation("用户列表")
    @GetMapping("/list")
    public Result<List<User>> list() {
        return Result.success(userService.list());
    };

    @ApiOperation("禁用用户")
    @PostMapping("/forbidden")
    public Result<?> forbidden(@RequestParam Integer userId){
        User byId = userService.getById(userId);
        if(byId!=null){
            byId.setStatus("1");
            userService.updateById(byId);
            return Result.success();
        }else {
            return Result.error("500","该用户不存在");
        }
    }

    @ApiOperation("注册用户")
    @PostMapping("/register")
    public Result<?> add(@RequestBody @Validated RegisterDTO registerDTO){
        List<User> list = userService.list(new LambdaQueryWrapper<User>().eq(User::getUsername,registerDTO.getUsername()));
        if(list.isEmpty()){
            User addUser = new User();
            addUser.setPhoneNumber(registerDTO.getPhoneNumber());
            addUser.setUsername(registerDTO.getUsername());
            //10次加盐加密
            addUser.setPassword(BCrypt.hashpw(registerDTO.getPassword()));
            addUser.setStatus("0");
            addUser.setCreateTime(DateUtil.toLocalDateTime(DateUtil.date()));
            addUser.setRole("user");
            userService.save(addUser);
            return Result.success(addUser);
        }else {
            return Result.error("500","该账号已经存在");
        }
    }


    @ApiOperation("登录返回token")
    @PostMapping("/login")
    public Result<?> login(@RequestBody @Validated LoginDTO loginDTO){
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername,loginDTO.getUsername());
        User user = userService.getOne(wrapper);
        if(user!=null){
            if(user.getStatus().equals("1")){
                return Result.error("500","用户已经被禁用,请联系管理员");
            }
            if(BCrypt.checkpw(loginDTO.getPassword(),user.getPassword())){
                StpUtil.login(user.getUserId());
                Map<String, Object> map =new HashMap<>();
                map.put("token", StpUtil.getTokenValue());
                return Result.success(map);
            }
            return Result.error("500","用户名或密码错误");
        }else {
            return Result.error("500","用户不存在");
        }

    }

    @ApiOperation("根据token查询用户信息")
    @GetMapping("/info")
    public Result<?> info(@RequestParam String token){
        log.info("token:{}",token);
        String loginId = (String) StpUtil.getLoginId();
        Map<String, Object> map =new HashMap<>();
        map.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        map.put("loginId", loginId);
        map.put("roles",userService.getById(loginId).getRole());
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
