package com.wangshuo.opencartstore.service.impl;

import com.wangshuo.opencartstore.dao.ReturnHistoryMapper;
import com.wangshuo.opencartstore.dao.ReturnMapper;
import com.wangshuo.opencartstore.po.ReturnHistory;
import com.wangshuo.opencartstore.service.ReturnHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReturnHistoryServiceImp implements ReturnHistoryService {
    @Autowired
    private ReturnHistoryMapper returnHistoryMapper;
    @Override
    public List<ReturnHistory> getReturnId(Integer returnID) {
        List<ReturnHistory> returnHistories = returnHistoryMapper.selectByReturnId(returnID);
        return returnHistories;
    }
}
