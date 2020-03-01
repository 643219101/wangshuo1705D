package com.wangshuo.opencartback.service;


import com.wangshuo.opencartback.po.Administrator;

public interface AdministratorService {

    Administrator getById(Integer administratorId);

    Administrator getByUsername(String username);

    void update(Administrator administrator);

}
