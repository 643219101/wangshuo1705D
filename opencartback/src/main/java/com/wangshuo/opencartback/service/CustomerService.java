package com.wangshuo.opencartback.service;

import com.github.pagehelper.Page;
import com.wangshuo.opencartback.dto.in.CustomerSearchInDTO;
import com.wangshuo.opencartback.dto.in.CustomerSetStatusInDTO;
import com.wangshuo.opencartback.po.Customer;


public interface CustomerService {

    Page<Customer> search(CustomerSearchInDTO customerSearchInDTO, Integer pageNum);

    Customer getById(Integer customerId);

    void setStatus(CustomerSetStatusInDTO customerSetStatusInDTO);

}
