package com.xy.wwoa.setting.api;

import com.xy.wwoa.setting.model.FixedcostsCategory;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * @Author 陈璇
 * @Description FixedcostsCategoryList
 * @date 2019/8/29 13:48
 */
@Getter
@ToString
@Builder
public class FixedcostsCategoryList {

    private List<FixedcostsCategory> list;
    private long total;
    private int page;

}
