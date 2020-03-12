package com.wangshuo.opencartback.controller;


import com.github.pagehelper.Page;
import com.wangshuo.opencartback.dto.in.CustomerSearchInDTO;
import com.wangshuo.opencartback.dto.in.CustomerSetStatusInDTO;
import com.wangshuo.opencartback.dto.out.CustomerListOutDTO;
import com.wangshuo.opencartback.dto.out.CustomerShowOutDTO;
import com.wangshuo.opencartback.dto.out.PageOutDTO;
import com.wangshuo.opencartback.po.Address;
import com.wangshuo.opencartback.po.Customer;
import com.wangshuo.opencartback.service.AddressService;
import com.wangshuo.opencartback.service.CustomerService;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {


    @Autowired
    private CustomerService customerService;

    @Autowired
    private AddressService addressService;


    @GetMapping("/search")
    public PageOutDTO<CustomerListOutDTO> search(CustomerSearchInDTO customerSearchInDTO,
                                                 @RequestParam(required = false,defaultValue = "1") Integer pageNum){
        Page<Customer> page = customerService.search(customerSearchInDTO, pageNum);
        List<CustomerListOutDTO> collect = page.stream().map(customer -> {
            CustomerListOutDTO customerListOutDTO = new CustomerListOutDTO();
            customerListOutDTO.setCustomerId(customer.getCustomerId());
            customerListOutDTO.setUsername(customer.getUsername());
            customerListOutDTO.setRealName(customer.getRealName());
            customerListOutDTO.setMobile(customer.getMobile());
            customerListOutDTO.setEmail(customer.getEmail());
            customerListOutDTO.setStatus(customer.getStatus());
            customerListOutDTO.setCreateTimestamp(customer.getCreateTime().getTime());
            return customerListOutDTO;
        }).collect(Collectors.toList());
        PageOutDTO<CustomerListOutDTO> pageOutDTO = new PageOutDTO<>();
        pageOutDTO.setTotal(page.getTotal());
        pageOutDTO.setTotal(page.getTotal());
        pageOutDTO.setPageSize(page.getPageSize());
        pageOutDTO.setPageNum(page.getPageNum());
        pageOutDTO.setList(collect);
        return pageOutDTO;
    }

    @GetMapping("/getById")
    public CustomerShowOutDTO getById(@RequestParam Integer customerId){
        Customer customer = customerService.getById(customerId);
        CustomerShowOutDTO customerShowOutDTO = new CustomerShowOutDTO();
        customerShowOutDTO.setCustomerId(customerId);
        customerShowOutDTO.setUsername(customer.getUsername());
        customerShowOutDTO.setRealName(customer.getRealName());
        customerShowOutDTO.setMobile(customer.getMobile());
        customerShowOutDTO.setEmail(customer.getEmail());
        customerShowOutDTO.setAvatarUrl(customer.getAvatarUrl());
        customerShowOutDTO.setStatus(customer.getStatus());
        customerShowOutDTO.setRewordPoints(customer.getRewordPoints());
        customerShowOutDTO.setNewsSubscribed(customer.getNewsSubscribed());
        customerShowOutDTO.setCreateTimestamp(customer.getCreateTime().getTime());
        customerShowOutDTO.setDefaultAddressId(customer.getDefaultAddressId());

        Address byId = addressService.getById(customer.getDefaultAddressId());
        if(byId!=null){
            customerShowOutDTO.setDefaultAddress(byId.getContent());

        }

        return customerShowOutDTO;
    }
    @PostMapping("/setStatus")
    public void setStatus(@RequestBody CustomerSetStatusInDTO customerSetStatusInDTO){
        customerService.setStatus(customerSetStatusInDTO);
    }


}
