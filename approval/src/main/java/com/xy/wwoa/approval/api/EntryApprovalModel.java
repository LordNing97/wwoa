package com.xy.wwoa.approval.api;

import com.xy.wwoa.employee.api.EmployeeInformationModel;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @Author leisurexi
 * @Description
 * @Date 2019/9/2
 * @Time 9:06
 */
@Getter
@ToString
@Builder
public class EntryApprovalModel {

    private String approvalNumber;
    private String employeeName;
    private String organizationName;
    private String jobName;
    private String takeOfficeCity;
    private LocalDateTime entryTime;
    private String telephone;
    private Integer probationTime;
    private String contractTypeName;
    private Integer contractTime;
    private String state;
    private String remark;
    private EmployeeInformationModel employeeInformationModel;

}
