package com.xy.wwoa.employee.api;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * @Author leisurexi
 * @Description
 * @Date 2019/8/27
 * @Time 19:22
 */
@Data
@Builder
@ToString
public class EmployeeModel {

    private Integer id;
    private String employeeName;
    private Integer organizationId;

}
