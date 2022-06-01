package com.ideal.jk.controller;


import com.baomidou.mybatisplus.extension.service.IService;
import com.ideal.jk.exception.CommonException;
import com.ideal.jk.pojo.po.DicItem;
import com.ideal.jk.pojo.po.Province;
import com.ideal.jk.pojo.query.DicItemQuery;
import com.ideal.jk.pojo.query.ProvinceQuery;
import com.ideal.jk.utils.Rs;
import org.springframework.beans.factory.annotation.Autowired;
import com.ideal.jk.service.ProvinceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/provinces")
public class ProvinceController extends BaseController<Province> {

    @Autowired
    private ProvinceService provinceService;

    @GetMapping("/list")
    public Map<String, Object> list(ProvinceQuery query) {
        provinceService.list(query);
        return Rs.ok(query);
    }

    @GetMapping("/detail")
    public Map<String, Object> detail(Integer id) {
        Province item = provinceService.getById(id);
        if (item == null) {
            Rs.error("查询失败");
        }
        return Rs.ok(item);
    }

    @Override
    protected IService<Province> getService() {
        return provinceService;
    }
}

