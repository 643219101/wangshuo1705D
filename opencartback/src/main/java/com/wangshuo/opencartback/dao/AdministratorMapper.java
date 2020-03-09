package com.wangshuo.opencartback.dao;

import com.github.pagehelper.Page;
import com.wangshuo.opencartback.po.Administrator;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdministratorMapper {
    int deleteByPrimaryKey(Integer administratorId);

    int insert(Administrator record);

    int insertSelective(Administrator record);

    Administrator selectByPrimaryKey(Integer administratorId);

    int updateByPrimaryKeySelective(Administrator record);

    int updateByPrimaryKey(Administrator record);

    Administrator selectByUsername(String username);


    int batchDelete(@Param("administratorId") List<Integer> administratorId);

    Administrator selectByEmail(@Param("email") String email);


    Page<Administrator> selectList();


}