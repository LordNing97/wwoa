package com.xy.wwoa.approval.api;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @Author 陈璇
 * @Description LeaveApprovalModal
 * @date 2019/9/2 11:39
 */
@Getter
@ToString
@Builder
public class LeaveApprovalModal {

    private String employeeName;
    private String idcard;
    private String organizationName;
    private String jobName;
    private LocalDateTime entryTime;
    private long workAge;
    private String leavingReason;
    private LocalDateTime leavingTime;
    private String workHandover;
    private String workHandoverEmployeeName;
    private String status;
    private String remark;

    private String actualApplicantName;
    private String approvalNumber;
    private LocalDateTime lastUpTime;


}
