package com.xy.wwoa.setting.model;

import lombok.Data;
import lombok.ToString;

/**
 * @Author 陈璇
 * @Description Company
 * @date 2019/8/30 9:01
 */
@Data
@ToString
public class Company {

    private Integer id;
    private String name;
    private String telephone;
    private String dutyParagraph;
    private String address;
    private String openingBank;
    private String accountNumber;
    private Integer status;
    private String remark;

}
