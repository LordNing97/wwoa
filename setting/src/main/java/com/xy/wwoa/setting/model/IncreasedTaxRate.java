package com.xy.wwoa.setting.model;

import lombok.Data;
import lombok.ToString;

/**
 * @Author 陈璇
 * @Description IncreasedTaxRate
 * @date 2019/8/29 14:38
 */
@Data
@ToString
public class IncreasedTaxRate {

    private Integer id;
    private String taxRate;
    private Integer status;
    private String describe;

}
