package com.xwz.fullstack.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 订单表
 * </p>
 *
 * @author XiaoWenzhuo
 * @since 2022-04-19
 */
@Data
@TableName("order")
@ApiModel(value = "Order对象", description = "订单表")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("订单id")
    @TableId(value = "order_id", type = IdType.AUTO)
    private Integer orderId;

    @ApiModelProperty("订单总价格")
    @TableField("price")
    private Integer price;

    @ApiModelProperty("订单创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty("收货地址")
    @TableField("address")
    private String address;

    @ApiModelProperty("联系方式")
    @TableField("phone")
    private String phone;

    @ApiModelProperty("订单对应用户id")
    @TableField("user_id")
    private Integer userId;
}




