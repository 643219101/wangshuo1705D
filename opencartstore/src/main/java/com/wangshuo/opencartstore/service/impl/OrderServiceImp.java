package com.wangshuo.opencartstore.service.impl;

import com.alibaba.fastjson.JSON;
import com.wangshuo.opencartstore.dao.OrderDetailMapper;
import com.wangshuo.opencartstore.dao.OrderMapper;
import com.wangshuo.opencartstore.dto.in.OrderCheckoutInDTO;
import com.wangshuo.opencartstore.dto.in.OrderProductInDTO;
import com.wangshuo.opencartstore.dto.out.ProductShowOutDTO;
import com.wangshuo.opencartstore.enumeration.OrderStatus;
import com.wangshuo.opencartstore.po.Address;
import com.wangshuo.opencartstore.po.Order;
import com.wangshuo.opencartstore.po.OrderDetail;
import com.wangshuo.opencartstore.po.Product;
import com.wangshuo.opencartstore.service.AddressService;
import com.wangshuo.opencartstore.service.OrderService;
import com.wangshuo.opencartstore.service.ProductService;
import com.wangshuo.opencartstore.vo.OrderProductVo;
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


    @Override
    @Transactional
    public Long checkout(OrderCheckoutInDTO orderCheckoutInDTO,Integer consumerId) {
        List<OrderProductInDTO> orderProductInDTOS = orderCheckoutInDTO.getOrderProducts();
        List<OrderProductVo> orderProductVOS = orderProductInDTOS.stream().map(orderProductInDTO -> {
            Product productById = productService.getProductById(orderProductInDTO.getProductId());
            OrderProductVo orderProductVo = new OrderProductVo();
            orderProductVo.setProductId(productById.getProductId());
            orderProductVo.setProductCode(productById.getProductCode());
            orderProductVo.setProductNmae(productById.getProductName());
            Integer quantity = orderProductInDTO.getQuantity();
            orderProductVo.setQuantity(quantity);
            Double unitPrice = productById.getPrice() * productById.getDiscount();
            orderProductVo.setUnitPrice(unitPrice);
            Double totalPrice=unitPrice*quantity;
            orderProductVo.setTotalPrice(totalPrice);
            Integer rewordPoints = productById.getRewordPoints();
            orderProductVo.setUnitRewordPoints(rewordPoints);
            Integer totalRewordPoints=rewordPoints*quantity;
            orderProductVo.setTotalRewordPoints(totalRewordPoints);
            return orderProductVo;

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
        orderDetail.setOrderProducts(JSON.toJSONString(orderProductVOS));
      orderDetailMapper.insertSelective(orderDetail);
        return orderid;
    }

}
