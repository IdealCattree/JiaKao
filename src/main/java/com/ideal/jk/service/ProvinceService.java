package com.ideal.jk.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ideal.jk.pojo.po.Province;
import com.ideal.jk.pojo.query.ProvinceQuery;

import java.util.List;

public interface ProvinceService extends IService<Province> {
    void list(ProvinceQuery query);
}

