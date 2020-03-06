package com.wangshuo.opencartback.service;

import com.github.pagehelper.Page;
import com.wangshuo.opencartback.po.Customer;


public interface CustomerService {

    Page<Customer> search(Integer pageNum);

    Customer getById(Integer customerId);

    //void setStatus(CustomerSetStatusInDTO customerSetStatusInDTO);

}
