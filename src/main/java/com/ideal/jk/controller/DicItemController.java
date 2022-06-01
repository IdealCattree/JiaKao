package com.ideal.jk.controller;


import com.baomidou.mybatisplus.extension.service.IService;
import com.ideal.jk.pojo.po.DicItem;
import com.ideal.jk.pojo.query.DicItemQuery;
import com.ideal.jk.service.DicItemService;
import com.ideal.jk.utils.Rs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/dicItems")
public class DicItemController extends BaseController<DicItem> {

    @Autowired
    private DicItemService dicItemService;

    @GetMapping("/list")
    public Map<String, Object> list(DicItemQuery query) {
        dicItemService.list(query);
        return Rs.ok(query);
    }

    @GetMapping("/detail")
    public Map<String, Object> detail(Integer id) {
        DicItem item = dicItemService.getById(id);
        if (item == null) {
            return Rs.error("查询失败");
        }
        return Rs.ok(item);
    }

    @Override
    protected IService<DicItem> getService() {
        return dicItemService;
    }

//    @PostMapping("/remove")
//    public Map<String, Object> remove(String ids) {
//        boolean b = dicItemService.removeByIds(Arrays.asList(ids.split(",")));
//
//        if (b) {
//            return Rs.ok("删除成功");
//        } else {
//            throw new CommonException("删除失败");
//        }
//    }
//
//    @PostMapping("/save")
//    public Map<String, Object> save(DicItem dicItem) {
//        boolean b = dicItemService.saveOrUpdate(dicItem);
//
//        if (b) {
//            return Rs.ok("保存成功");
//        } else {
//            throw new CommonException("保存失败");
//        }
//    }

}

