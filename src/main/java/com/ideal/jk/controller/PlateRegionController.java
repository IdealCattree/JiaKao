package com.ideal.jk.controller;


import com.baomidou.mybatisplus.extension.service.IService;
import com.ideal.jk.pojo.po.PlateRegion;
import com.ideal.jk.pojo.query.CityQuery;
import com.ideal.jk.pojo.query.ProvinceQuery;
import com.ideal.jk.pojo.result.R;
import com.ideal.jk.utils.Rs;
import org.springframework.beans.factory.annotation.Autowired;
import com.ideal.jk.service.PlateRegionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/plateRegions")
public class PlateRegionController extends BaseController<PlateRegion> {

    @Autowired
    private PlateRegionService plateRegionService;

    @GetMapping("/listProvinces")
    public R listProvinces(ProvinceQuery query) {
        plateRegionService.listProvinces(query);
        return Rs.ok(query);
    }

    @GetMapping("/allProvinces")
    public R allProvinces() {
        List<PlateRegion> plateRegions = plateRegionService.allProvinces();
        return Rs.ok(plateRegions);
    }

    @GetMapping("listCities")
    public R listCities(CityQuery query) {
        plateRegionService.listCities(query);
        return Rs.ok(query);
    }

    @Override
    protected IService<PlateRegion> getService() {
        return plateRegionService;
    }
}

