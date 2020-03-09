package com.wangshuo.opencartstore.service;

import com.wangshuo.opencartstore.po.OrderHistory;

import java.util.List;

public interface OrderHistoryService {

    List<OrderHistory> getByOrderId(Long orderId);

}
