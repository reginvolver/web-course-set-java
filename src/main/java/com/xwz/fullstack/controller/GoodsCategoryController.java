package com.xwz.fullstack.controller;


import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xwz.fullstack.common.Result;
import com.xwz.fullstack.entity.GoodsCategory;
import com.xwz.fullstack.service.GoodsCategoryService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 商品类别表 前端控制器
 * </p>
 *
 * @author XiaoWenzhuo
 * @since 2022-04-19
 */
@RestController
@SaCheckLogin
@RequestMapping("/goodsCategory")
public class GoodsCategoryController {
    @Autowired
    GoodsCategoryService goodsCategoryService;

    @ApiOperation("新增商品分类")
    @PostMapping("/add")
    public Result<?> addGood(@RequestBody @Validated GoodsCategory goodsCategory){
        goodsCategoryService.save(goodsCategory);
        return Result.success("新增成功");
    }
    
    @ApiOperation("根据商品id更新商品")
    @PostMapping("/update")
    public Result<?> updateGood(@RequestBody @Validated GoodsCategory goodsCategory){
        goodsCategoryService.updateById(goodsCategory);
        return Result.success("更新成功");
    }

    @ApiOperation("删除商品类型")
    @DeleteMapping("/delete")
    public Result<?> deleteGoodsCategory(@RequestParam @Validated Integer goodCategoryId){
        if(goodsCategoryService.removeById(goodCategoryId)){
            return Result.success("删除成功");
        }else {
            return Result.error("500","无此商品类型");
        }
    }


    @ApiOperation("分页查找商品 根据分类名称查询")
    @GetMapping("/find")
    public Result<?> findPageGood(@RequestParam(defaultValue = "1") Integer pageNum,
                                  @RequestParam(defaultValue = "10") Integer pageSize,
                                  @RequestParam(defaultValue = "") String search
    ){
        LambdaQueryWrapper<GoodsCategory> wrapper = new LambdaQueryWrapper<>();

        if(StrUtil.isNotBlank(search)){
            wrapper.like(GoodsCategory::getCategoryName,search);
        }
        Page<GoodsCategory> userPage = goodsCategoryService.page(new Page<>(pageNum, pageSize), wrapper);
        return Result.success(userPage);
    }

}
