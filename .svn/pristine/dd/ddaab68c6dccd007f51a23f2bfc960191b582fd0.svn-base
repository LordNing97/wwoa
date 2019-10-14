package com.xy.wwoa.approval.strategy;

import com.xy.wwoa.approval.api.ApprovalDetail;
import com.xy.wwoa.approval.api.ApprovalModel;

/**
 * @Author leisurexi
 * @Description
 * @Date 2019/8/31
 * @Time 11:46
 */
public interface ApprovalStrategy {

    /**
     * 审批基本信息
     */
    ApprovalModel buildApprovalModel(String approvalNumber, Integer approvalTypeId);

    /**
     * 审批详细信息
     */
    ApprovalDetail buildApprovalDetail(String approvalNumber, Integer approvalTypeId);

    /**
     * 通过审批
     */
    void approved(String approvalNumber);

}
