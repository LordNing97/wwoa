package com.xy.wwoa.approval.api;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @Author leisurexi
 * @Description
 * @Date 2019/8/29
 * @Time 10:03
 */
@Getter
@ToString
@Builder
public class ApprovalProcessModel {

    private String approverName;
    private Integer status;
    private String state;
    private LocalDateTime approvalTime;
    private String approvalOpinion;

}
