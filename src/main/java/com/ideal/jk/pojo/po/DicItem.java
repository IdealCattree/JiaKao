package com.ideal.jk.pojo.po;

import lombok.Data;

@Data
public class DicItem {
    
    private long id;
    
    private String name;
    
    private String value;
    //排列顺序 默认为0 值越大越在前面
    private Long sn;
    //是否禁用 0 启用 1禁用
    private Short disabled;
    //所属类型
    private Integer typeId;
}

