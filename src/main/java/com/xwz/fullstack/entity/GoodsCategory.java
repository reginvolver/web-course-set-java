package com.xwz.fullstack.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 商品类别表
 * </p>
 *
 * @author XiaoWenzhuo
 * @since 2022-04-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class GoodsCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 商品类别id
     */
    @TableId(value = "category_id", type = IdType.AUTO)
    private Integer categoryId;

    /**
     * 类别名称
     */
    private String nameCategory;


}
