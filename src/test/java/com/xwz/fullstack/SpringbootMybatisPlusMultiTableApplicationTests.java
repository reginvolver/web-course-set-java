package com.xwz.fullstack;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xwz.fullstack.entity.dto.GoodsCategoryVO;
import com.xwz.fullstack.service.GoodsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class SpringbootMybatisPlusMultiTableApplicationTests {

    @Autowired
    private GoodsService goodsService;

    /**
     * 联表查询并分页
     */
    @Test
    public void contextLoads() {
        // 当前页，总条数 构造 page 对象
        Page<GoodsCategoryVO> page = new Page<>(1, 10);
        page.setRecords(goodsService.getGoodCategory(page));
        System.out.println(page);
    }

}

