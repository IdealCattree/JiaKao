package com.ideal.jk.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fasterxml.jackson.core.TSFBuilder;
import com.ideal.jk.pojo.result.R;
import com.ideal.jk.utils.Rs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;

public abstract class BaseController<T> {
    protected abstract IService<T> getService();

    @PostMapping("/remove")
    public R remove(String id) {
        boolean b = getService().removeByIds(Arrays.asList(id.split(",")));
        if (b) {
            return Rs.ok("删除成功");
        } else {
            return Rs.error("删除失败");
        }
    }

    @PostMapping("/save")
    public R save(T entity) {
        boolean b = getService().saveOrUpdate(entity);
        if (b) {
            return Rs.ok("保存成功");
        } else {
            return Rs.error("保存失败");
        }
    }
}
