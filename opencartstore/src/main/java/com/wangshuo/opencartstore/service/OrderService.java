package com.wangshuo.opencartstore.service;

import com.wangshuo.opencartstore.dto.in.OrderCheckoutInDTO;
import com.wangshuo.opencartstore.dto.out.OrderShowOutDTO;

public interface OrderService {

    Long checkout(OrderCheckoutInDTO orderCheckoutInDTO,Integer consumerId);

    OrderShowOutDTO getById(Long orderId);

}
