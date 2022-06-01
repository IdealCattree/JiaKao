package com.ideal.jk.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.promeg.pinyinhelper.Pinyin;
import com.ideal.jk.enhance.MpPage;
import com.ideal.jk.enhance.MpQueryWrapper;
import com.ideal.jk.mapper.PlateRegionMapper;
import com.ideal.jk.pojo.po.PlateRegion;
import com.ideal.jk.pojo.query.CityQuery;
import com.ideal.jk.pojo.query.ProvinceQuery;
import com.ideal.jk.pojo.result.R;
import com.ideal.jk.service.PlateRegionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
@Transactional
public class PlateRegionServiceImpl extends ServiceImpl<PlateRegionMapper, PlateRegion> implements PlateRegionService {

    @Override
    public boolean save(PlateRegion entity) {
        processPinyin(entity);
        return super.save(entity);
    }

    @Override
    public boolean updateById(PlateRegion entity) {
        processPinyin(entity);
        return super.updateById(entity);
    }

    public void processPinyin(PlateRegion entity) {
        String name = entity.getName();
        if (name == null || name.length() == 0) return;

        entity.setPinyin(Pinyin.toPinyin(name, ""));
    }

    @Override
    @Transactional(readOnly = true)
    public void listProvinces(ProvinceQuery query) {

        MpQueryWrapper<PlateRegion> wrapper = new MpQueryWrapper<>();

        // 搜索条件
        wrapper.like(query.getKeyword(), PlateRegion::getName, PlateRegion::getPinyin, PlateRegion::getPlate);

        // 查询省份
        wrapper.like(PlateRegion::getParentId, 0);

        baseMapper.selectPage(new MpPage<>(query), wrapper).updateQuery(query);
    }

    @Override
    @Transactional(readOnly = true)
    public void listCities(CityQuery query) {

        MpQueryWrapper<PlateRegion> wrapper = new MpQueryWrapper<>();

        wrapper.like(query.getKeyword(), PlateRegion::getName, PlateRegion::getPlate, PlateRegion::getPinyin);

        Integer parentId = query.getParentId();

        // 判断查询条件中是否指定了某个省份的id
        if (parentId != null && parentId > 0) {
            // 查询指定省份下的所有城市
            wrapper.eq(PlateRegion::getParentId, parentId);
        } else {
            // 查询所有城市
            wrapper.ne(PlateRegion::getParentId, 0);
        }

        baseMapper.selectPage(new MpPage<>(query), wrapper).updateQuery(query);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PlateRegion> allProvinces() {
        MpQueryWrapper<PlateRegion> wrapper = new MpQueryWrapper<>();
        wrapper.like(PlateRegion::getParentId, 0);
        wrapper.orderByAsc(PlateRegion::getPinyin);
        return baseMapper.selectList(wrapper);
    }

}

