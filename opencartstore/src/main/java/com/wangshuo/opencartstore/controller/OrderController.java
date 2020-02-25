package com.wangshuo.opencartstore.controller;

import com.wangshuo.opencartstore.dto.in.OrderCheckoutInDTO;
import com.wangshuo.opencartstore.dto.out.OrderListOutDTO;
import com.wangshuo.opencartstore.dto.out.OrderShowOutDTO;
import com.wangshuo.opencartstore.dto.out.PageOutDTO;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @PostMapping("/checkout")
    public Integer checkout(@RequestBody OrderCheckoutInDTO orderCheckoutInDTO,
                            @RequestAttribute Integer customerId){
        return null;
    }

    @GetMapping("/getList")
    public PageOutDTO<OrderListOutDTO> getList(@RequestAttribute Integer customerId){
        return null;
    }

    @GetMapping("/getById")
    public OrderShowOutDTO getById(@RequestParam Long orderId){
        return null;
    }
}
