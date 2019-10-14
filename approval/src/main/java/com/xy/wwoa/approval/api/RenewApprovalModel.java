package com.xy.wwoa.approval.api;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Author leisurexi
 * @Description
 * @Date 2019/9/2
 * @Time 11:07
 */
@Getter
@ToString
@Builder
public class RenewApprovalModel {

    private String approvalNumber;
    private String employeeName;
    private String organizationName;
    private String jobName;
    private LocalDateTime maturityTime;
    private BigDecimal renewSalary;
    private String workShow;
    private String performance;
    private String state;
    private String remark;

}
