package com.solitude.Ecommerce.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.solitude.Ecommerce.entity.Dish;
import com.solitude.Ecommerce.mapper.DishMapper;
import com.solitude.Ecommerce.service.DishService;
import org.springframework.stereotype.Service;

@Service
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish> implements DishService {
}
