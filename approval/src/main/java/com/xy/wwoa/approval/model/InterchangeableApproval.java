package com.xy.wwoa.approval.model;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @Author leisurexi
 * @Description
 * @Date 2019/8/31
 * @Time 15:20
 */
@Data
@ToString
public class InterchangeableApproval {

    private Integer id;
    private String approvalNumber;
    private Integer organizationId;
    private Integer jobId;
    private String applyContent;
    private String approvalDetail;
    private String imgs;
    private String approverIds;
    private String ccIds;
    private Integer createUser;
    private LocalDateTime createTime;
    private Integer status;
    private String remark;

    private String createUserName;
    private String jobName;

}
