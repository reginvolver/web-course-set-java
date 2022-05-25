package com.xwz.fullstack.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xwz.fullstack.entity.Goods;
import com.xwz.fullstack.entity.dto.GoodsCategoryVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 商品表 Mapper 接口
 * </p>
 *
 * @author XiaoWenzhuo
 * @since 2022-04-19
 */
@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {
    @Select("SELECT good_id,price,good_name,goods_category.category_name,good_status,create_time from goods , goods_category " +
            "where goods_category.category_id = goods.good_category ")
    List<GoodsCategoryVO> getGoodCategory(Page<GoodsCategoryVO> page);
}
