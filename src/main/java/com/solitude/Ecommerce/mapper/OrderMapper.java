package com.solitude.Ecommerce.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.solitude.Ecommerce.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper extends BaseMapper<Orders> {
}
