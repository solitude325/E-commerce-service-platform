package com.solitude.Ecommerce.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.solitude.Ecommerce.common.R;
import com.solitude.Ecommerce.entity.OrderDetail;

import java.util.List;

public interface OrderDetailService extends IService<OrderDetail> {
    R<List<OrderDetail>> getByOrderId(Long id);
}
