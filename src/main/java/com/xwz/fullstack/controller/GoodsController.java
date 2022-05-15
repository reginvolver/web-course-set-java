package com.xwz.fullstack.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xwz.fullstack.common.Result;
import com.xwz.fullstack.entity.Goods;
import com.xwz.fullstack.service.GoodsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 商品表 前端控制器
 * </p>
 *
 * @author XiaoWenzhuo
 * @since 2022-04-19
 */
@RestController
@SaCheckLogin
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    GoodsService goodsService;

    @ApiOperation("新增商品")
    @PostMapping("/add")
    public Result<?> addGood(@RequestBody @Validated Goods good){
        goodsService.save(good);
        return Result.success("新增成功");
    }

    @ApiOperation("根据商品id更新商品")
    @PostMapping("/update")
    public Result<?> updateGood(@RequestBody @Validated  Goods good){
        goodsService.updateById(good);
        return Result.success("更新成功");
    }

    @ApiOperation("删除商品")
    @DeleteMapping ("/delete")
    public Result<?> deleteGood(@RequestParam Integer goodId){
        if(goodsService.removeById(goodId)){
            return Result.success("删除成功");
        }else {
            return Result.error("500","无此商品");
        }
    }


    @ApiOperation("分页查找商品 可根据商品名称 分类查询")
    @GetMapping("/find")
    public Result<?> findPageGood(@RequestParam(defaultValue = "1") Integer pageNum,
                                  @RequestParam(defaultValue = "10") Integer pageSize,
                                  @RequestParam(defaultValue = "") String search,
                                  @RequestParam(defaultValue="") String category
    ){
        LambdaQueryWrapper<Goods> wrapper = new LambdaQueryWrapper<>();
        if(StrUtil.isNotBlank(category)){
            wrapper.eq(Goods::getGoodCategory,category);
        }
        if(StrUtil.isNotBlank(search)){
            wrapper.like(Goods::getGoodName,search);
        }
        Page<Goods> userPage = goodsService.page(new Page<>(pageNum, pageSize), wrapper);
        return Result.success(userPage);
    }


}
