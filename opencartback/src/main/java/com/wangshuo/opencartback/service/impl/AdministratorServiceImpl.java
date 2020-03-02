package com.wangshuo.opencartback.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wangshuo.opencartback.dao.AdministratorMapper;
import com.wangshuo.opencartback.po.Administrator;
import com.wangshuo.opencartback.service.AdministratorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    private AdministratorMapper administratorMapper;

    @Override
    public Administrator getById(Integer administratorId) {
        Administrator administrator = administratorMapper.selectByPrimaryKey(administratorId);
        return administrator;
    }

    @Override
    public Administrator getByUsername(String username) {
        Administrator administrator = administratorMapper.selectByUsername(username);
        return administrator;
    }

    @Override
    public void update(Administrator administrator) {
        administratorMapper.updateByPrimaryKeySelective(administrator);
    }

    @Override
    public Integer create(Administrator administrator) {
        int i = administratorMapper.insertSelective(administrator);
        return i;
    }

    @Override
    public void delete(Integer administratorId) {
    administratorMapper.deleteByPrimaryKey(administratorId);
    }

    @Override
    public void batchDelete(List<Integer> administratorIds) {

        administratorMapper.batchDelete(administratorIds);
    }

    @Override
    public Page<Administrator> selectList(Integer pageNum) {
        PageHelper.startPage(pageNum,10);
        Page<Administrator> list = administratorMapper.selectList();
        return list;
    }
}
