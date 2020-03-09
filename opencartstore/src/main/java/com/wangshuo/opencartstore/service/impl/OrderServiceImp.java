package com.wangshuo.opencartstore.service.impl;

import com.alibaba.fastjson.JSON;
import com.wangshuo.opencartstore.dao.OrderDetailMapper;
import com.wangshuo.opencartstore.dao.OrderMapper;
import com.wangshuo.opencartstore.dto.in.OrderCheckoutInDTO;
import com.wangshuo.opencartstore.dto.in.OrderProductInDTO;
import com.wangshuo.opencartstore.dto.out.OrderHistoryListOutDTO;
import com.wangshuo.opencartstore.dto.out.OrderShowOutDTO;
import com.wangshuo.opencartstore.enumeration.OrderStatus;
import com.wangshuo.opencartstore.po.*;
import com.wangshuo.opencartstore.service.AddressService;
import com.wangshuo.opencartstore.service.OrderHistoryService;
import com.wangshuo.opencartstore.service.OrderService;
import com.wangshuo.opencartstore.service.ProductService;

import com.wangshuo.opencartstore.vo.OrderProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImp implements OrderService {
    @Autowired
       private OrderMapper orderMapper;
    @Autowired
    private OrderDetailMapper orderDetailMapper;
    @Autowired
    private ProductService productService;

    @Autowired
    private AddressService addressService;
     @Autowired
     private OrderHistoryService orderHistoryService;

    @Override
    @Transactional
    public Long checkout(OrderCheckoutInDTO orderCheckoutInDTO,Integer consumerId) {
        List<OrderProductInDTO> orderProductInDTOS = orderCheckoutInDTO.getOrderProducts();
        List<OrderProductVO> orderProductVOS = orderProductInDTOS.stream().map(orderProductInDTO -> {
            Product productById = productService.getProductById(orderProductInDTO.getProductId());
            OrderProductVO orderProductVO = new OrderProductVO();
            orderProductVO.setProductId(productById.getProductId());
            orderProductVO.setProductCode(productById.getProductCode());
            orderProductVO.setProductNmae(productById.getProductName());
            Integer quantity = orderProductInDTO.getQuantity();
            orderProductVO.setQuantity(quantity);
            Double unitPrice = productById.getPrice() * productById.getDiscount();
            orderProductVO.setUnitPrice(unitPrice);
            Double totalPrice=unitPrice*quantity;
            orderProductVO.setTotalPrice(totalPrice);
            Integer rewordPoints = productById.getRewordPoints();
            orderProductVO.setUnitRewordPoints(rewordPoints);
            Integer totalRewordPoints=rewordPoints*quantity;
            orderProductVO.setTotalRewordPoints(totalRewordPoints);
            return orderProductVO;

        }).collect(Collectors.toList());


        double sumPrice = orderProductVOS.stream().mapToDouble(p -> p.getUnitPrice()).sum();
        int sumPoints = orderProductVOS.stream().mapToInt(p -> p.getTotalRewordPoints()).sum();


        Order order=new Order();
        order.setCustomerId(consumerId);
        order.setStatus((byte) OrderStatus.ToProcess.ordinal());
        order.setTotalPrice(sumPrice);
       order.setRewordPoints(sumPoints);
        Date date = new Date();
        order.setCreateTime(date);
        order.setUpdateTime(date);
        int orderId = orderMapper.insertSelective(order);
        Long orderId1 = order.getOrderId();
        Long orderid = new Long((long)orderId1);


        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderId(orderid);
        orderDetail.setShipMethod(orderCheckoutInDTO.getShipMethod());
        orderDetail.setPayMethod(orderCheckoutInDTO.getPayMethod());
        orderDetail.setShipPrice(5.0);
        Address shipAddress = addressService.getById(orderCheckoutInDTO.getShipAddressId());
        orderDetail.setShipAddress(shipAddress.getContent());
        Address invoiceAddress = addressService.getById(orderCheckoutInDTO.getInvoiceAddressId());
        orderDetail.setInvoiceAddress(invoiceAddress.getContent());
        orderDetail.setInvoicePrice(sumPrice);
        orderDetail.setComment(orderCheckoutInDTO.getComment());
        String comment = orderCheckoutInDTO.getComment();
        System.out.println(comment);
        orderDetail.setComment(comment);
        orderDetail.setOrderProducts(JSON.toJSONString(orderProductVOS));
         orderDetailMapper.insertSelective(orderDetail);
        return orderid;
    }

    @Override
    public OrderShowOutDTO getById(Long orderId) {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        OrderDetail orderDetail = orderDetailMapper.selectByPrimaryKey(orderId);

        OrderShowOutDTO orderShowOutDTO = new OrderShowOutDTO();
        orderShowOutDTO.setOrderId(orderId);
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

        List<OrderHistory> orderHistories = orderHistoryService.getByOrderId(orderId);
        List<OrderHistoryListOutDTO> orderHistoryListOutDTOS = orderHistories.stream().map(orderHistory -> {
            OrderHistoryListOutDTO orderHistoryListOutDTO = new OrderHistoryListOutDTO();
            orderHistoryListOutDTO.setTimestamp(orderHistory.getTime().getTime());
            orderHistoryListOutDTO.setOrderStatus(orderHistory.getOrderStatus());
            orderHistoryListOutDTO.setComment(orderHistory.getComment());
            return orderHistoryListOutDTO;
        }).collect(Collectors.toList());

        orderShowOutDTO.setOrderHistories(orderHistoryListOutDTOS);

        return orderShowOutDTO;

    }

}
