package com.ideal.jk.enhance;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ideal.jk.pojo.query.PageQuery;

public class MpPage<T> extends Page<T> {
    public MpPage(PageQuery query) {
        super(query.getPageNumber(), query.getPageSize());
    }

    public void updateQuery(PageQuery query) {
        query.setData(getRecords());
        query.setTotal(getTotal());
        query.setPages(getPages());
        query.setPageNumber(getCurrent());
        query.setPageSize(getSize());
    }
}
