package com.xy.wwoa.approval.model;


import com.xy.wwoa.employee.model.Employee;
import com.xy.wwoa.employee.model.EmployeeInformation;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @Author 陈璇
 * @Description LeaveApproval
 * @date 2019/8/31 9:25
 */
@Data
@ToString
public class LeaveApproval {

    private Integer id;
    private Integer actualApplicantId;
    private String approvalNumber;
    private String leavingReason;
    private LocalDateTime leavingTime;
    private Integer workHandover;
    private Integer workHandoverEmployee;
    private String approverIds;
    private String ccIds;
    private Integer createUser;
    private LocalDateTime createTime;
    private Integer status;
    private String remark;

    private String createUserName;
    private Employee actualApplicant;
    private EmployeeInformation actualApplicantInformation;

}
