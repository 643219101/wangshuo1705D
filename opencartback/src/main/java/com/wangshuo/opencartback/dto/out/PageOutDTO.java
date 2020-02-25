package com.wangshuo.opencartback.dto.out;

import java.util.List;

public class PageOutDTO<T> {
    //总数
    private Integer total;
    //一页多少条
    private Integer pageSize;
    //当前得页码是多少
    private Integer pageNum;
    //list集合
    private List<T> list;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
