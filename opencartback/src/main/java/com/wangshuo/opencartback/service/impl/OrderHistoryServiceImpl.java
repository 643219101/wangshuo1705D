package com.wangshuo.opencartback.service.impl;


import com.wangshuo.opencartback.dao.OrderHistoryMapper;
import com.wangshuo.opencartback.po.Order;
import com.wangshuo.opencartback.po.OrderHistory;
import com.wangshuo.opencartback.service.OrderHistoryService;
import com.wangshuo.opencartback.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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

    @Override
    public Long create(OrderHistory orderHistory) {

        int i = orderHistoryMapper.insertSelective(orderHistory);
        Long orderHistoryId = new Long((long) i);
        return orderHistoryId;
    }

//    @Override
//    @Transactional
//    public Long create(OrderHistory orderHistory) {
//        orderHistoryMapper.insertSelective(orderHistory);
//        Order order = new Order();
//
//        order.setOrderId(orderHistory.getOrderHistoryId());
//        order.setStatus(orderHistory.getOrderStatus());
//        order.setUpdateTime(new Date());
//        orderService.update(order);
//        Long orderHistoryId = orderHistory.getOrderHistoryId();
//        return orderHistoryId;
//    }
}
