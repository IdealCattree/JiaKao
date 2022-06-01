package com.ideal.jk.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ideal.jk.enhance.MpPage;
import com.ideal.jk.enhance.MpQueryWrapper;
import com.ideal.jk.mapper.DicTypeMapper;
import com.ideal.jk.pojo.po.DicType;
import com.ideal.jk.pojo.query.DicTypeQuery;
import com.ideal.jk.service.DicTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DicTypeServiceImpl extends ServiceImpl<DicTypeMapper, DicType> implements DicTypeService {

    @Override
    @Transactional(readOnly = true)
    public void list(DicTypeQuery query) {
        MpQueryWrapper<DicType> wrapper = new MpQueryWrapper<>();
        String keyword = query.getKeyword();

        if (!StringUtils.isEmpty(keyword)) {
//            wrapper.like(DicType::getName, keyword).or()
//                    .like(DicType::getValue, keyword).or()
//                    .like(DicType::getIntro, keyword);
            wrapper.like(keyword, DicType::getName, DicType::getValue, DicType::getIntro);

        }


        MpPage<DicType> page = new MpPage<>(query);


        baseMapper.selectPage(page, wrapper).updateQuery(query);
    }
}
