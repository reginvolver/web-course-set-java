package com.xwz.fullstack.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Description: 商品类型关联VO
 * @author: XiaoWenzhuo
 * @date: 2022-05-25 10:08
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GoodsCategoryVO implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("商品id")
    private Integer goodId;
    @ApiModelProperty("商品名称")
    private String goodName;
    @ApiModelProperty("类型名称")
    private String categoryName;
    @ApiModelProperty("商品状态")
    private String goodStatus;
    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;
}
