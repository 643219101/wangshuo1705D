package com.wangshuo.opencartback.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wangshuo.opencartback.dao.OrderDetailMapper;
import com.wangshuo.opencartback.dao.OrderMapper;
import com.wangshuo.opencartback.dto.out.OrderListOutDTO;
import com.wangshuo.opencartback.dto.out.OrderShowOutDTO;
import com.wangshuo.opencartback.po.Customer;
import com.wangshuo.opencartback.po.Order;
import com.wangshuo.opencartback.po.OrderDetail;
import com.wangshuo.opencartback.po.Product;
import com.wangshuo.opencartback.service.CustomerService;
import com.wangshuo.opencartback.service.OrderService;
import com.wangshuo.opencartback.vo.OrderProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImp implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
  private CustomerService customerService;
    @Autowired
    private OrderDetailMapper orderDetailMapper;
    @Override
    public Page<OrderListOutDTO> search(Integer pageNum) {
        PageHelper.startPage(pageNum,10);
        Page<OrderListOutDTO> search = orderMapper.search();
        return search;
    }

    @Override
    public OrderShowOutDTO getById(Long orderId) {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        OrderDetail orderDetail = orderDetailMapper.selectByPrimaryKey(orderId);

        OrderShowOutDTO orderShowOutDTO = new OrderShowOutDTO();
        orderShowOutDTO.setOrderId(orderId);
        orderShowOutDTO.setCustomerId(order.getCustomerId());
        Customer customer = customerService.getById(order.getCustomerId());
        orderShowOutDTO.setCustomerName(customer.getRealName());
        orderShowOutDTO.setStatus(order.getStatus());
        orderShowOutDTO.setTotalPrice(order.getTotalPrice());
        orderShowOutDTO.setRewordPoints(order.getRewordPoints());
        orderShowOutDTO.setCreateTimestamp(order.getCreateTime().getTime());
        orderShowOutDTO.setUpdateTimestamp(order.getUpdateTime().getTime());

        orderShowOutDTO.setShipMethod(orderDetail.getShipMethod());
        orderShowOutDTO.setShipAddress(orderDetail.getShipAddress());
        orderShowOutDTO.setShipPrice(orderDetail.getShipPrice());
        orderShowOutDTO.setPayMethod(orderDetail.getPayMethod());
        orderShowOutDTO.setInvoiceAddress(orderDetail.getInvoiceAddress());
        orderShowOutDTO.setInvoicePrice(orderDetail.getInvoicePrice());
        orderShowOutDTO.setComment(orderDetail.getComment());

        List<OrderProductVO> orderProductVOS = JSON.parseArray(orderDetail.getOrderProducts(), OrderProductVO.class);
        orderShowOutDTO.setOrderProducts(orderProductVOS);

        return orderShowOutDTO;
    }
}
