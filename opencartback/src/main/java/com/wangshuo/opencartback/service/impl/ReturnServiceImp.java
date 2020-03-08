package com.wangshuo.opencartback.service.impl;

import com.wangshuo.opencartback.dao.ReturnMapper;
import com.wangshuo.opencartback.po.Return;
import com.wangshuo.opencartback.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReturnServiceImp  implements ReturnService {
@Autowired
 private ReturnMapper returnMapper;

    @Override
    public Integer create(Return aturn) {
      returnMapper.insertSelective(aturn);
        Integer returnId = aturn.getReturnId();
        return returnId;
    }
}
