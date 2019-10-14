package com.xy.wwoa.setting.model;

import lombok.Data;
import lombok.ToString;

/**
 * @Author 陈璇
 * @Description FixedcostsCategory
 * @date 2019/8/28 17:19
 */
@Data
@ToString
public class FixedcostsCategory {

    private Integer id;
    private String category;
    private Integer status;
    private String remark;

}
