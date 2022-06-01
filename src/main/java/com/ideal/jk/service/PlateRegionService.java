package com.ideal.jk.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ideal.jk.pojo.po.PlateRegion;
import com.ideal.jk.pojo.query.CityQuery;
import com.ideal.jk.pojo.query.ProvinceQuery;

import java.util.List;

public interface PlateRegionService extends IService<PlateRegion> {
    void listProvinces(ProvinceQuery query);

    void listCities(CityQuery query);

    List<PlateRegion> allProvinces();
}

