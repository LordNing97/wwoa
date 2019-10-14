package com.xy.wwoa.approval.strategy;

import com.xy.wwoa.approval.api.ApprovalDetail;
import com.xy.wwoa.approval.api.ApprovalModel;
import com.xy.wwoa.approval.model.ApprovalProcess;
import com.xy.wwoa.approval.model.RenewApproval;
import com.xy.wwoa.approval.service.ApprovalProcessService;
import com.xy.wwoa.approval.service.RenewApprovalService;
import com.xy.wwoa.approval.util.ApprovalUtil;
import com.xy.wwoa.common.util.DateUtil;
import com.xy.wwoa.common.util.SpringBeanUtil;
import com.xy.wwoa.employee.service.EmployeeInformationService;

/**
 * @Author leisurexi
 * @Description 合同续签审批实现类
 * @Date 2019/8/31
 * @Time 14:36
 */
public class RenewApprovalStrategy implements ApprovalStrategy {

    private RenewApprovalService renewApprovalService = SpringBeanUtil.getBean(RenewApprovalService.class);
    private EmployeeInformationService employeeInformationService = SpringBeanUtil.getBean(EmployeeInformationService.class);
    private ApprovalProcessService approvalProcessService = SpringBeanUtil.getBean(ApprovalProcessService.class);

    @Override
    public ApprovalModel buildApprovalModel(String approvalNumber, Integer approvalTypeId) {
        RenewApproval renewApproval = renewApprovalService.getByApprovalNumber(approvalNumber);
        ApprovalProcess last = approvalProcessService.getLast(approvalNumber);
        ApprovalModel approvalModel = ApprovalModel.builder()
                .approvalNumber(renewApproval.getApprovalNumber())
                .approvalTypeId(approvalTypeId)
                .approverId(last.getApproverId())
                .createUserName(renewApproval.getCreateUserName())
                .title(renewApproval.getCreateUserName() + "提交的合同续签")
                .subTitle1("合同到期时间: " + DateUtil.convertDateToString(renewApproval.getMaturityTime()))
                .subTitle2("续签薪资: " + renewApproval.getRenewSalary())
                .subTitle3("工作表现: " + renewApproval.getWorkShow())
                .createUser(renewApproval.getCreateUser())
                .createTime(renewApproval.getCreateTime())
                .status(last.getStatus())
                .state(ApprovalUtil.approvalStatusStr(last.getStatus(), last.getApproverName()))
                .build();
        return approvalModel;
    }

    @Override
    public ApprovalDetail buildApprovalDetail(String approvalNumber, Integer approvalTypeId) {
        RenewApproval renewApproval = renewApprovalService.getByApprovalNumber(approvalNumber);
        ApprovalDetail approvalDetail = ApprovalDetail.builder()
                .createUser(renewApproval.getCreateUser())
                .createUserName(renewApproval.getCreateUserName())
                .createTime(renewApproval.getCreateTime())
                .ccIds(renewApproval.getCcIds())
                .approvalContent(renewApproval)
                .build();
        return approvalDetail;
    }

    @Override
    public void approved(String approvalNumber) {
        RenewApproval renewApproval = renewApprovalService.getByApprovalNumber(approvalNumber);
        employeeInformationService.modifyContractRenew(renewApproval.getActualApplicantId(), renewApproval.getRenewSalary(), renewApproval.getMaturityTime());
    }

}
