package com.xy.wwoa.employee.api;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * @Author leisurexi
 * @Description
 * @Date 2019/8/27
 * @Time 16:11
 */
@Data
@Builder
@ToString
public class ApprovalEmployeeModel {

    private Integer id;
    private String organizationName;
    private String approvalTypeName;
    private String managerName;
    private String leaderNames;
    private String personnelNames;
    private String financeNames;

}
