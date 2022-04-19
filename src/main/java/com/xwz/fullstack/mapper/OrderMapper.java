package com.xwz.fullstack.mapper;

import com.xwz.fullstack.entity.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 订单表 Mapper 接口
 * </p>
 *
 * @author XiaoWenzhuo
 * @since 2022-04-19
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

}
