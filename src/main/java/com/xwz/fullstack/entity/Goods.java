package com.xwz.fullstack.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 商品表
 * </p>
 *
 * @author XiaoWenzhuo
 * @since 2022-04-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Goods implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品id
     */
    @TableId(value = "good_id", type = IdType.AUTO)
    private Integer goodId;

    /**
     * 商品金额
     */
    private BigDecimal price;

    /**
     * 商品名称
     */
    private String goodName;

    /**
     * 商品类别 对应 goods_category category_id
     */
    private Integer goodCategory;

    /**
     * 商品状态 0 正常 1 下架
     */
    private String goodStatus;

    /**
     * 创建时间
     */
    private Date createTime;


}
