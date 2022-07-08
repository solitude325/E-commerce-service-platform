package com.solitude.Ecommerce.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.solitude.Ecommerce.entity.DishFlavor;
import com.solitude.Ecommerce.mapper.DishFlavorMapper;
import com.solitude.Ecommerce.service.DishFlavorService;
import org.springframework.stereotype.Service;

@Service
public class DishFlavorServiceImpl extends ServiceImpl<DishFlavorMapper, DishFlavor> implements DishFlavorService {
}
