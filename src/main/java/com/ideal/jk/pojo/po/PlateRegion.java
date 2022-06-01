package com.ideal.jk.pojo.po;

import lombok.Data;

@Data
public class PlateRegion {
    
    private Integer id;
    //名称
    private String name;
    //车牌
    private String plate;
    //拼音全称
    private String pinyin;
    //所属省份的id 如果是省份则为0
    private Integer parentId;
}

