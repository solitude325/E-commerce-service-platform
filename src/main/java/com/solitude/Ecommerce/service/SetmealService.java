package com.solitude.Ecommerce.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.solitude.Ecommerce.dto.SetmealDto;
import com.solitude.Ecommerce.entity.Setmeal;

import java.util.List;

public interface SetmealService extends IService<Setmeal> {
    public void saveWithDish(SetmealDto setmealDto);

    public void removeWithDish(List<Long> ids);

    public SetmealDto getByIdWithDish(Long id);

    public void updateWithDish(SetmealDto setmealDto);
}
