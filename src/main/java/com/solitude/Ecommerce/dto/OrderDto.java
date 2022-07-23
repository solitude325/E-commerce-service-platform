package com.solitude.Ecommerce.dto;

import com.solitude.Ecommerce.entity.OrderDetail;
import com.solitude.Ecommerce.entity.Orders;
import lombok.Data;

import java.util.List;

@Data
public class OrderDto extends Orders {
    private String userName;

    private String phone;

    private String address;

    private String consignee;

    private List<OrderDetail> orderDetails;
}
