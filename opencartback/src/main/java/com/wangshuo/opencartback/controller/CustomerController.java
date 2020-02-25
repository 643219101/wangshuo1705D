package com.wangshuo.opencartback.controller;


import com.wangshuo.opencartback.dto.in.CustomerSearchInDTO;
import com.wangshuo.opencartback.dto.out.CustomerListOutDTO;
import com.wangshuo.opencartback.dto.out.CustomerShowOutDTO;
import com.wangshuo.opencartback.dto.out.PageOutDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @GetMapping("/search")
    public PageOutDTO<CustomerListOutDTO> search(CustomerSearchInDTO customerSearchInDTO, @RequestParam Integer pageNum){

        return  null;
    }

    @GetMapping("/getById")
    public CustomerShowOutDTO getById(@RequestParam Integer customerId){
       return  null;
    }


    @PostMapping("/disable")
    public  void disable(@RequestParam Integer customerId){
    
    }

}
