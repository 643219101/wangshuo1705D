package com.wangshuo.opencartback.service;

import com.wangshuo.opencartback.po.Address;

import java.util.List;

public interface AddressService {

    Address getById(Integer addressId);

    List<Address> getByCustomerId(Integer customerId);

}
