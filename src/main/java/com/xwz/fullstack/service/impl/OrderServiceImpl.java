package com.xwz.fullstack.service.impl;

import com.xwz.fullstack.entity.Order;
import com.xwz.fullstack.mapper.OrderMapper;
import com.xwz.fullstack.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author XiaoWenzhuo
 * @since 2022-04-17
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

}
