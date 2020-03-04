package com.wangshuo.opencartstore.controller;

import com.wangshuo.opencartstore.dto.in.OrderCheckoutInDTO;
import com.wangshuo.opencartstore.dto.out.OrderListOutDTO;
import com.wangshuo.opencartstore.dto.out.OrderShowOutDTO;
import com.wangshuo.opencartstore.dto.out.PageOutDTO;

import com.wangshuo.opencartstore.po.Order;
import com.wangshuo.opencartstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {
 @Autowired
 private OrderService orderService;

    @PostMapping("/checkout")
    public Long checkout(@RequestBody OrderCheckoutInDTO orderCheckoutInDTO,
                            @RequestAttribute Integer customerId){
        Long checkout = orderService.checkout(orderCheckoutInDTO, customerId);



        return checkout;
    }

    @GetMapping("/getList")
    public PageOutDTO<OrderListOutDTO> getList(@RequestParam(required = false,defaultValue = "1") Integer pageNum
            ,@RequestAttribute Integer customerId){
        return null;
    }

    @GetMapping("/getById")
    public OrderShowOutDTO getById(@RequestParam Long orderId){
        return null;
    }
}
