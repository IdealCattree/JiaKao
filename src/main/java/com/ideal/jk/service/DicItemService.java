package com.ideal.jk.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ideal.jk.pojo.po.DicItem;
import com.ideal.jk.pojo.query.DicItemQuery;

import java.util.List;

public interface DicItemService extends IService<DicItem> {
    void list(DicItemQuery query);
}

