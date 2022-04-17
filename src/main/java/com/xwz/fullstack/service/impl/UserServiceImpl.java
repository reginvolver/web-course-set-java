package com.xwz.fullstack.service.impl;

import com.xwz.fullstack.entity.User;
import com.xwz.fullstack.mapper.UserMapper;
import com.xwz.fullstack.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author XiaoWenzhuo
 * @since 2022-04-17
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
