package com.xy.wwoa.setting.model;

import lombok.Data;
import lombok.ToString;

/**
 * @Author 陈璇
 * @Description ReimbursementCategory
 * @date 2019/8/28 11:54
 */
@Data
@ToString
public class ReimbursementCategory {

    private Integer id;
    private String category;
    private Integer status;
    private String remark;

}
