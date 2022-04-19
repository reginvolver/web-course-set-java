package com.xwz.fullstack.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 商品类别表
 * </p>
 *
 * @author XiaoWenzhuo
 * @since 2022-04-19
 */
@Data
@TableName("goods_category")
@ApiModel(value = "GoodsCategory对象", description = "商品类别表")
public class GoodsCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("商品类别id")
    @TableId(value = "category_id", type = IdType.AUTO)
    private Integer categoryId;

    @ApiModelProperty("类别名称")
    @TableField("name_category")
    private String nameCategory;


}




