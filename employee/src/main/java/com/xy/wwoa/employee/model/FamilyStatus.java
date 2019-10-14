package com.xy.wwoa.employee.model;

import lombok.Data;
import lombok.ToString;

/**
 * @Author 陈璇
 * @Description FamilyStatus
 * @date 2019/8/30 17:23
 */
@Data
@ToString
public class FamilyStatus {

    private Integer id;
    private String memberFamily;
    private String relationship;
    private String occupation;

}
