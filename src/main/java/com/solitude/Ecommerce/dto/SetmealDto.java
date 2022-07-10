package com.solitude.Ecommerce.dto;

import com.solitude.Ecommerce.entity.Setmeal;
import com.solitude.Ecommerce.entity.SetmealDish;
import lombok.Data;
import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
