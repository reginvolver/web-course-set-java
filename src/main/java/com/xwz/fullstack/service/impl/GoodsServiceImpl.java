package com.xwz.fullstack.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xwz.fullstack.entity.Goods;
import com.xwz.fullstack.entity.dto.GoodsCategoryVO;
import com.xwz.fullstack.mapper.GoodsMapper;
import com.xwz.fullstack.service.GoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商品表 服务实现类
 * </p>
 *
 * @author XiaoWenzhuo
 * @since 2022-04-19
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {
    @Autowired
    GoodsMapper goodsMapper;


    public List<GoodsCategoryVO> getGoodCategory(Page<GoodsCategoryVO> page) {
        return this.baseMapper.getGoodCategory(page);
    }
}
