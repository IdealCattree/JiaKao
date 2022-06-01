package com.ideal.jk.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ideal.jk.enhance.MpPage;
import com.ideal.jk.enhance.MpQueryWrapper;
import com.ideal.jk.mapper.ProvinceMapper;
import com.ideal.jk.pojo.po.Province;
import com.ideal.jk.pojo.query.ProvinceQuery;
import com.ideal.jk.service.ProvinceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class ProvinceServiceImpl extends ServiceImpl<ProvinceMapper, Province> implements ProvinceService {

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public void list(ProvinceQuery query) {
        MpPage<Province> page = new MpPage<>(query);

        MpQueryWrapper<Province> wrapper = new MpQueryWrapper<>();
        String keyword = query.getKeyword();

        if (keyword != null) {
            wrapper.like(Province::getName, keyword).or()
                    .like(Province::getPlate, keyword);
        }
        wrapper.orderByDesc(Province::getId);
        baseMapper.selectPage(page, wrapper).updateQuery(query);
    }
}

