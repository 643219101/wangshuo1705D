package com.wangshuo.opencartstore.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wangshuo.opencartstore.dao.ReturnMapper;
import com.wangshuo.opencartstore.po.Return;
import com.wangshuo.opencartstore.service.ReturnHistoryService;
import com.wangshuo.opencartstore.service.ReturnService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReturnServiceImpl implements ReturnService {

    @Autowired
    private ReturnMapper returnMapper;
    @Autowired
    private ReturnHistoryService returnHistoryService;


    @Override
    public Integer create(Return aReturn) {
        returnMapper.insertSelective(aReturn);
        Integer returnId = aReturn.getReturnId();
        return returnId;
    }

    @Override
    public Page<Return> getPageByCustomerId(Integer customerId, Integer pageNum) {
        PageHelper.startPage(pageNum, 10);
        Page<Return> page = returnMapper.selectPageByCustomerId(customerId);
        return page;
    }

    @Override
    public Return getById(Integer returnId) {
        Return aReturn = returnMapper.selectByPrimaryKey(returnId);
        return aReturn;
    }
}
