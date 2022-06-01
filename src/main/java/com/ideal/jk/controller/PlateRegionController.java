package com.ideal.jk.controller;


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

@RestController
@RequestMapping("/plateRegions")
public class PlateRegionController {

    @Autowired
    private PlateRegionService plateRegionService;

    @GetMapping("/listProvinces")
    public R listProvinces(ProvinceQuery query) {
        plateRegionService.listProvinces(query);
        return Rs.ok(query);
    }

    @GetMapping("listCities")
    public R listCities(CityQuery query) {
        plateRegionService.listCities(query);
        return Rs.ok(query);
    }

}

