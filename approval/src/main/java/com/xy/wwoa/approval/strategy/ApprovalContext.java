package com.xy.wwoa.approval.strategy;

import com.xy.wwoa.approval.api.ApprovalDetail;
import com.xy.wwoa.approval.api.ApprovalModel;

/**
 * @Author leisurexi
 * @Description
 * @Date 2019/8/31
 * @Time 12:01
 */
public class ApprovalContext {

    private ApprovalStrategy approvalStrategy;
    private Integer approvalTypeId;

    public ApprovalContext(Integer approvalTypeId) {
        this.approvalTypeId = approvalTypeId;
        approvalStrategy = ApprovalFactory.getInstance().buildApprovalModel(approvalTypeId);
    }

    public ApprovalModel buildApprovalModel(String approvalNumber) {
        return approvalStrategy.buildApprovalModel(approvalNumber, approvalTypeId);
    }

    public ApprovalDetail buildApprovalDetail(String approvalNumber) {
        return approvalStrategy.buildApprovalDetail(approvalNumber, approvalTypeId);
    }

    public void approved(String approvalNumber) {
        approvalStrategy.approved(approvalNumber);
    }

}
