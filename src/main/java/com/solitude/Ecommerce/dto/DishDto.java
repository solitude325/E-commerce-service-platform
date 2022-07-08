package com.solitude.Ecommerce.dto;

import com.solitude.Ecommerce.entity.Dish;
import com.solitude.Ecommerce.entity.DishFlavor;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class DishDto extends Dish {

    private List<DishFlavor> flavors = new ArrayList<>();

    private String categoryName;

    private Integer copies;
}
