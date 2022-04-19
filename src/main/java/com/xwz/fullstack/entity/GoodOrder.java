package com.xwz.fullstack.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 商品订单表
 * </p>
 *
 * @author XiaoWenzhuo
 * @since 2022-04-19
 */
@Data
@TableName("good_order")
@ApiModel(value = "GoodOrder对象", description = "商品订单表")
public class GoodOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("商品订单联系id")
    @TableId(value = "good_order_id", type = IdType.AUTO)
    private Integer goodOrderId;

    @ApiModelProperty("商品id")
    @TableField("good_id")
    private Integer goodId;

    @ApiModelProperty("订单id")
    @TableField("order_id")
    private Integer orderId;

    @ApiModelProperty("该商品数目")
    @TableField("count")
    private Integer count;

    @ApiModelProperty("该商品价格")
    @TableField("price")
    private BigDecimal price;


}




