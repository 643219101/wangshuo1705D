package com.wangshuo.opencartstore.service.impl;

import com.wangshuo.opencartstore.dao.OrderHistoryMapper;
import com.wangshuo.opencartstore.po.OrderHistory;
import com.wangshuo.opencartstore.service.OrderHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderHistoryServiceImpl implements OrderHistoryService {

    @Autowired
    private OrderHistoryMapper orderHistoryMapper;

    @Override
    public List<OrderHistory> getByOrderId(Long orderId) {
        List<OrderHistory> orderHistories = orderHistoryMapper.selectByOrderId(orderId);
        return orderHistories;
    }
}
