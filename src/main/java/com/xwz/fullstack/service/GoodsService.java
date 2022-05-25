package com.xwz.fullstack.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xwz.fullstack.entity.Goods;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xwz.fullstack.entity.dto.GoodsCategoryVO;

import java.util.List;

/**
 * <p>
 * 商品表 服务类
 * </p>
 *
 * @author XiaoWenzhuo
 * @since 2022-04-19
 */
public interface GoodsService extends IService<Goods> {
    List<GoodsCategoryVO> getGoodCategory(Page<GoodsCategoryVO> page);
}
