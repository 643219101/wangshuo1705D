package com.wangshuo.opencartstore.service;

import com.wangshuo.opencartstore.po.ReturnHistory;

import java.util.List;

public interface ReturnHistoryService {
    List<ReturnHistory>  getReturnId(Integer returnID);
}
