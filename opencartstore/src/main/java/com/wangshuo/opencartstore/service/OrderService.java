package com.wangshuo.opencartstore.service;

import com.wangshuo.opencartstore.dto.in.OrderCheckoutInDTO;

public interface OrderService {

    Long checkout(OrderCheckoutInDTO orderCheckoutInDTO,Integer consumerId);
}
