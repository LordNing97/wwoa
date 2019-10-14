package com.xy.wwoa.approval.api;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @Author 陈璇
 * @Description PerformanceAppraisalProcessesModal
 * @date 2019/9/7 9:44
 */
@Data
@ToString
@Builder
public class PerformanceAppraisalProcessesModal {

    private String employeeName;
    private LocalDateTime approvalTime;
    private Integer status;
    private String state;
    private String approvalOpinion;

}
