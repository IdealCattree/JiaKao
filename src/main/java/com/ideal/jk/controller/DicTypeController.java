package com.ideal.jk.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ideal.jk.pojo.po.DicType;
import com.ideal.jk.pojo.query.DicTypeQuery;
import com.ideal.jk.pojo.result.R;
import com.ideal.jk.service.DicTypeService;
import com.ideal.jk.utils.Rs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dic-types")
public class DicTypeController extends BaseController<DicType> {

    @Autowired
    private DicTypeService service;

    @GetMapping("/list")
    public Map<String, Object> list(DicTypeQuery query) {
        service.list(query);
        return Rs.ok(query);
    }

    @Override
    protected IService<DicType> getService() {
        return service;
    }

//    @PostMapping("/remove")
//    public R remove(String id) {
//        boolean b = service.removeByIds(Arrays.asList(id.split(",")));
//        if (b) {
//            return Rs.ok("删除成功");
//        } else {
//            return Rs.error("删除失败");
//        }
//    }
//
//    @PostMapping("/save")
//    public R save(DicType dicType) {
//        boolean save = service.saveOrUpdate(dicType);
//        if (save) {
//            return Rs.ok("保存成功");
//        } else {
//            return Rs.error("保存失败");
//        }
//    }
}
