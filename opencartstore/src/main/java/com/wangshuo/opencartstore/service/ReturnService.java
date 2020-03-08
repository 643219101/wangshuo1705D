package com.wangshuo.opencartstore.service;

import com.github.pagehelper.Page;
import com.wangshuo.opencartstore.po.Return;

public interface ReturnService {

    Integer create(Return aReturn);

    Page<Return> getPageByCustomerId(Integer customerId, Integer pageNum);

    Return getById(Integer returnId);

}
