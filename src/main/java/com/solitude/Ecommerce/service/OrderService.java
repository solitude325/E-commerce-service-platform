package com.solitude.Ecommerce.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.solitude.Ecommerce.common.R;
import com.solitude.Ecommerce.dto.OrderDto;
import com.solitude.Ecommerce.entity.Orders;

public interface OrderService extends IService<Orders> {
    public void submit(Orders orders);

    void updateStatusById(OrderDto ordersDto);

    R<Page> userPage(Page pageInfo);

    R<Page> pageQuery(Page pageInfo, String number, String beginTime, String endTime);
}
