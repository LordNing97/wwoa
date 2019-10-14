package com.xy.wwoa.setting.model;

import lombok.Data;
import lombok.ToString;

/**
 * @Author leisurexi
 * @Description
 * @Date 2019/8/28
 * @Time 9:21
 */
@Data
@ToString
public class ContractType {

    private Integer id;
    private String name;
    private Integer status;
    private String remark;

}
