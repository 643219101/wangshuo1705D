package com.wangshuo.opencartstore.service;

import com.wangshuo.opencartstore.po.Customer;

public interface CustomerService {
    Customer getByUsername(String username);

}
