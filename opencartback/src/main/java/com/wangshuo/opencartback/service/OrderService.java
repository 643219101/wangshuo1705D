package com.wangshuo.opencartback.service;

import com.github.pagehelper.Page;
import com.wangshuo.opencartback.dto.out.OrderListOutDTO;
import com.wangshuo.opencartback.dto.out.OrderShowOutDTO;
import com.wangshuo.opencartback.po.Order;

public interface OrderService {

    Page<OrderListOutDTO> search(Integer pageNum);

    OrderShowOutDTO getById(Long orderId);
}
