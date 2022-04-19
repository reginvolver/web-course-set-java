package com.xwz.fullstack.mapper;

import com.xwz.fullstack.entity.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

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

}
