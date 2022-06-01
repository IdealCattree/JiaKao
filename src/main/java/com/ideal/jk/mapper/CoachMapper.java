package com.ideal.jk.mapper;

import com.ideal.jk.pojo.po.Coach;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoachMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Coach record);

    Coach selectByPrimaryKey(Long id);

    List<Coach> selectAll();

    int updateByPrimaryKey(Coach record);
}