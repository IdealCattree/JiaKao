package com.ideal.jk.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ideal.jk.pojo.po.DicType;
import com.ideal.jk.pojo.query.DicTypeQuery;

import java.util.List;

public interface DicTypeService extends IService<DicType> {

    void list(DicTypeQuery query);
}
