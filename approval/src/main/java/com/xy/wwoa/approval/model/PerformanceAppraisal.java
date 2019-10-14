package com.xy.wwoa.approval.model;

import com.xy.wwoa.employee.model.Employee;
import com.xy.wwoa.employee.model.EmployeeInformation;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @Author 陈璇
 * @Description PerformanceAppraisal
 * @date 2019/8/31 11:43
 */
@Data
@ToString
public class PerformanceAppraisal {

    private Integer id;
    private String approvalNumber;
    private Integer employeeId;
    private Integer organizationId;
    private Integer jobId;
    private String lastWorkTask;
    private String realityWorkTask;
    private Integer taskCompleteRate;
    private String lastWorkAppraisal;
    private String workTask;
    private String workPlan;
    private String approverIds;
    private String ccIds;
    private Integer createUser;
    private LocalDateTime createTime;
    private Integer status;
    private String remark;

    private String createUserName;
    private Employee employee;
    private EmployeeInformation employeeInformation;

}
