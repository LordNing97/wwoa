package com.xy.wwoa.approval.api;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @Author 陈璇
 * @Description InterchangeableApprovalModal
 * @date 2019/9/5 16:13
 */
@Getter
@ToString
@Builder
public class InterchangeableApprovalModal {

    private String organizationName;
    private String employeeName;
    private LocalDateTime createTime;
    private String applyContent;
    private String imgs;
    private String approvalNumber;
    private String approvalDetail;


}
