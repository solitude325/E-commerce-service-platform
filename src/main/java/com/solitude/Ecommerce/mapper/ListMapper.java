package com.solitude.Ecommerce.mapper;

import com.solitude.Ecommerce.entity.Sales;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ListMapper {
    @Select("select name, SUM(amount) AS number FROM order_detail GROUP BY name ORDER BY number DESC LIMIT 5")
    List<Sales> listAll();
}
