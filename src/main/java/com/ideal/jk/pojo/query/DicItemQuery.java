package com.ideal.jk.pojo.query;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class DicItemQuery extends KeywordQuery {
    private Integer typeId;
}
