package com.solitude.Ecommerce.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.solitude.Ecommerce.common.CustomException;
import com.solitude.Ecommerce.entity.Category;
import com.solitude.Ecommerce.entity.Dish;
import com.solitude.Ecommerce.entity.Setmeal;
import com.solitude.Ecommerce.mapper.CategoryMapper;
import com.solitude.Ecommerce.service.CategoryService;
import com.solitude.Ecommerce.service.DishService;
import com.solitude.Ecommerce.service.SetmealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Autowired
    private DishService dishService;
    @Autowired
    private SetmealService setmealService;

    @Override
    public void remove(List<Long> ids) {
        LambdaQueryWrapper<Dish> dishLambdaQueryWrapper = new LambdaQueryWrapper<>();
        dishLambdaQueryWrapper.in(Dish::getCategoryId,ids);
        int count1 = dishService.count(dishLambdaQueryWrapper);
        if (count1>0){
            throw new CustomException("With Dish!");
        }

        LambdaQueryWrapper<Setmeal> setmealLambdaQueryWrapper = new LambdaQueryWrapper<>();
        setmealLambdaQueryWrapper.in(Setmeal::getCategoryId,ids);
        int count2 = setmealService.count(setmealLambdaQueryWrapper);
        if (count2>0){
            throw new CustomException("With Setmeal!");
        }

        super.removeByIds(ids);
    }
}
