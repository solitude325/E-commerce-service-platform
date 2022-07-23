package com.solitude.Ecommerce.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.solitude.Ecommerce.common.R;
import com.solitude.Ecommerce.entity.OrderDetail;
import com.solitude.Ecommerce.mapper.OrderDetailMapper;
import com.solitude.Ecommerce.service.OrderDetailService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService {
    @Override
    public R<List<OrderDetail>> getByOrderId(Long id) {
        LambdaQueryWrapper<OrderDetail> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(OrderDetail::getOrderId,id);
        List<OrderDetail> orderDetails = this.list(queryWrapper);
        AtomicInteger amount = new AtomicInteger(0);
        return R.success(orderDetails);
    }
}
