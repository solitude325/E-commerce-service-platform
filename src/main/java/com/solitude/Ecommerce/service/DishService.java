package com.solitude.Ecommerce.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.solitude.Ecommerce.dto.DishDto;
import com.solitude.Ecommerce.entity.Dish;

public interface DishService extends IService<Dish> {
    public void saveWithFlavor(DishDto dishDto);
}
