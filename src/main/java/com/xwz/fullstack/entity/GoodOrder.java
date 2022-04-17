package com.xwz.fullstack.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 商品订单表
 * </p>
 *
 * @author XiaoWenzhuo
 * @since 2022-04-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class GoodOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品订单联系id
     */
    @TableId(value = "good_order_id", type = IdType.AUTO)
    private Integer goodOrderId;

    /**
     * 商品id
     */
    private Integer goodId;

    /**
     * 订单id
     */
    private Integer orderId;

    /**
     * 该商品数目
     */
    private Integer count;

    /**
     * 该商品价格
     */
    private BigDecimal price;


}
