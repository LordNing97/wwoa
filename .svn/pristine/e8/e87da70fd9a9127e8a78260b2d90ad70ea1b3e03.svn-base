package com.xy.wwoa.approval.strategy;

import com.xy.wwoa.approval.api.ApprovalDetail;
import com.xy.wwoa.approval.api.ApprovalModel;
import com.xy.wwoa.approval.api.LeaveApprovalModal;
import com.xy.wwoa.approval.model.ApprovalProcess;
import com.xy.wwoa.approval.model.LeaveApproval;
import com.xy.wwoa.approval.service.ApprovalProcessService;
import com.xy.wwoa.approval.service.LeaveApprovalService;
import com.xy.wwoa.approval.util.ApprovalUtil;
import com.xy.wwoa.common.util.CommonUtil;
import com.xy.wwoa.common.util.DateUtil;
import com.xy.wwoa.common.util.SpringBeanUtil;
import com.xy.wwoa.employee.mapper.EmployeeMapper;
import com.xy.wwoa.employee.mapper.OrganizationMapper;
import com.xy.wwoa.employee.mapper.ProvinceMapper;

/**
 * @Author 陈璇
 * @Description LeaveApprovalStrategy
 * @date 2019/8/31 15:04
 */
public class LeaveApprovalStrategy implements ApprovalStrategy{

    private LeaveApprovalService leaveApprovalService = SpringBeanUtil.getBean(LeaveApprovalService.class);

    private OrganizationMapper organizationMapper = SpringBeanUtil.getBean(OrganizationMapper.class);

    private ApprovalProcessService approvalProcessService = SpringBeanUtil.getBean(ApprovalProcessService.class);

    private EmployeeMapper employeeMapper = SpringBeanUtil.getBean(EmployeeMapper.class);

    @Override
    public ApprovalModel buildApprovalModel(String approvalNumber, Integer approvalTypeId) {
        LeaveApproval leaveApproval = leaveApprovalService.getByApprovalNumber(approvalNumber);
        ApprovalProcess last = approvalProcessService.getLast(approvalNumber);
        ApprovalModel approvalModel = ApprovalModel.builder()
                .approvalNumber(leaveApproval.getApprovalNumber())
                .approvalTypeId(approvalTypeId)
                .createUserName(leaveApproval.getCreateUserName())
                .title(leaveApproval.getCreateUserName() + "提交的离职")
                .subTitle1("实际申请人: " + leaveApproval.getActualApplicant().getEmployeeName())
                .subTitle2("入职日期: " + DateUtil.convertDateToString(leaveApproval.getActualApplicantInformation().getEntryTime()))
                .subTitle3("最后工作日: " + DateUtil.convertDateToString(leaveApproval.getActualApplicant().getLastLoginTime()))
                .createUser(leaveApproval.getCreateUser())
                .createTime(leaveApproval.getCreateTime())
                .approverId(last.getApproverId())
                .status(last.getStatus())
                .state(ApprovalUtil.approvalStatusStr(last.getStatus(), last.getApproverName()))
                .build();
        return approvalModel;
    }

    @Override
    public ApprovalDetail buildApprovalDetail(String approvalNumber, Integer approvalTypeId) {
        LeaveApproval leaveApproval = leaveApprovalService.getByApprovalNumber(approvalNumber);
        LeaveApprovalModal leaveApprovalModal = LeaveApprovalModal.builder()
                .approvalNumber(leaveApproval.getApprovalNumber())
                .organizationName(organizationMapper.findById(leaveApproval.getActualApplicant().getOrganizationId()).getOrganizationName())
                .actualApplicantName(leaveApproval.getActualApplicant().getEmployeeName())
                .entryTime(leaveApproval.getActualApplicantInformation().getEntryTime())
                .lastUpTime(leaveApproval.getActualApplicant().getLastUpTime())
                .leavingReason(leaveApproval.getLeavingReason())
                .workHandoverEmployeeName(employeeMapper.findById(leaveApproval.getWorkHandoverEmployee()).getEmployeeName())
                .leavingTime(leaveApproval.getLeavingTime())
                .remark(CommonUtil.fillNull(leaveApproval.getRemark()))
                .build();
        ApprovalDetail approvalDetail = ApprovalDetail.builder()
                .createUser(leaveApproval.getCreateUser())
                .createUserName(leaveApproval.getCreateUserName())
                .createTime(leaveApproval.getCreateTime())
                .ccIds(leaveApproval.getCcIds())
                .approvalContent(leaveApprovalModal)
                .build();
        return approvalDetail;
    }

    @Override
    public void approved(String approvalNumber) {
        LeaveApproval leaveApproval = leaveApprovalService.getByApprovalNumber(approvalNumber);
        leaveApprovalService.employeeTurnover(leaveApproval.getActualApplicantId());
    }
}
