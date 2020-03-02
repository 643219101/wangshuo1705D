package com.wangshuo.opencartback.service;


import com.github.pagehelper.Page;
import com.wangshuo.opencartback.po.Administrator;

import java.util.List;

public interface AdministratorService {

    Administrator getById(Integer administratorId);

    Administrator getByUsername(String username);

    void update(Administrator administrator);

    Integer create(Administrator administrator);

    void delete(Integer administratorId);

    void batchDelete(List<Integer> administratorIds);


      Page<Administrator> selectList(Integer pageNum);
}
