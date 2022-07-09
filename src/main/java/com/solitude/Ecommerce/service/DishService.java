package com.solitude.Ecommerce.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.solitude.Ecommerce.dto.DishDto;
import com.solitude.Ecommerce.entity.Dish;

import java.util.List;

public interface DishService extends IService<Dish> {
    public void saveWithFlavor(DishDto dishDto);

    public DishDto getByIdWithFlavor(Long id);

    public void updateWithFlavor(DishDto dishDto);

    public void remove(List<Long> ids);
}
