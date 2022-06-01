package com.ideal.jk.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ideal.jk.enhance.MpPage;
import com.ideal.jk.enhance.MpQueryWrapper;
import com.ideal.jk.mapper.DicItemMapper;
import com.ideal.jk.pojo.po.DicItem;
import com.ideal.jk.pojo.query.DicItemQuery;
import com.ideal.jk.service.DicItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DicItemServiceImpl extends ServiceImpl<DicItemMapper, DicItem> implements DicItemService {

    @Override
    @Transactional(readOnly = true)
    public void list(DicItemQuery query) {
        MpPage<DicItem> page = new MpPage<>(query);

        MpQueryWrapper<DicItem> wrapper = new MpQueryWrapper<>();
        String keyword = query.getKeyword();

        if (keyword != null) {
            wrapper.like(keyword, DicItem::getName, DicItem::getValue);
        }

        Integer typeId = query.getTypeId();
        if (typeId != null && typeId > 0) {
            wrapper.like(query.getTypeId(), DicItem::getTypeId);
        }

        wrapper.orderByDesc(DicItem::getId);
        baseMapper.selectPage(page, wrapper).updateQuery(query);

    }
}

