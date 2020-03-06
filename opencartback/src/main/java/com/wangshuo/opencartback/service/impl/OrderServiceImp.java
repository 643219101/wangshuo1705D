package com.wangshuo.opencartback.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wangshuo.opencartback.dao.OrderDetailMapper;
import com.wangshuo.opencartback.dao.OrderMapper;
import com.wangshuo.opencartback.dto.out.OrderListOutDTO;
import com.wangshuo.opencartback.po.Product;
import com.wangshuo.opencartback.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImp implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderDetailMapper orderDetailMapper;
    @Override
    public Page<OrderListOutDTO> search(Integer pageNum) {
        PageHelper.startPage(pageNum,10);
        Page<OrderListOutDTO> search = orderMapper.search();
        return search;
    }
}
