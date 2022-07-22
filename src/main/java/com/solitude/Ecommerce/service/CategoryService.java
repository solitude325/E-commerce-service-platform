package com.solitude.Ecommerce.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.solitude.Ecommerce.entity.Category;

import java.util.List;

public interface CategoryService extends IService<Category> {
    public void remove(List<Long> ids);
}
