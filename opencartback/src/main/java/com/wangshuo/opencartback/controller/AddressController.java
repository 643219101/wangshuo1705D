package com.wangshuo.opencartback.controller;

import com.wangshuo.opencartback.dto.out.AddressListOutDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {
    public List<AddressListOutDTO> getListByCustomerId(@RequestParam Integer customerId){
        return  null;
    }
}
