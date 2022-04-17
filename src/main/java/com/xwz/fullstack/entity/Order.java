package com.xwz.fullstack.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 订单表
 * </p>
 *
 * @author XiaoWenzhuo
 * @since 2022-04-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单id
     */
    @TableId(value = "order_id", type = IdType.AUTO)
    private Integer orderId;

    /**
     * 订单总价格
     */
    private Integer price;

    /**
     * 订单创建时间
     */
    private Date createTime;

    /**
     * 收货地址
     */
    private String address;

    /**
     * 联系方式
     */
    private String phone;

    /**
     * 订单对应用户id

     */
    private Integer userId;


}
