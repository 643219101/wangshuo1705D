package com.wangshuo.opencartstore.service.impl;

import com.wangshuo.opencartstore.dao.CustomerMapper;
import com.wangshuo.opencartstore.po.Customer;
import com.wangshuo.opencartstore.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;
    @Override
    public Customer getByUsername(String username) {
        Customer customer = customerMapper.selectByUsername(username);

        return customer;
    }
}
