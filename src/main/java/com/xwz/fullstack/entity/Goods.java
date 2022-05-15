package com.xwz.fullstack.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 商品表
 * </p>
 *
 * @author XiaoWenzhuo
 * @since 2022-04-19
 */
@Data
@TableName("goods")
@ApiModel(value = "Goods对象", description = "商品表")
public class Goods implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("商品id")
    @TableId(value = "good_id", type = IdType.AUTO)
    private Integer goodId;

    @ApiModelProperty("商品金额")
    @NotBlank
    @TableField("price")
    private BigDecimal price;

    @ApiModelProperty("商品名称")
    @NotBlank
    @TableField("good_name")
    private String goodName;

    @ApiModelProperty("商品类别 对应 goods_category category_id")
    @NotBlank
    @TableField("good_category")
    private Integer goodCategory;

    @ApiModelProperty("商品状态 0 正常 1 下架")
    @TableField("good_status")
    private String goodStatus;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;


}




