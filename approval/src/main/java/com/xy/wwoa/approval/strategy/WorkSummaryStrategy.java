package com.xy.wwoa.approval.strategy;

import com.xy.wwoa.approval.api.ApprovalDetail;
import com.xy.wwoa.approval.api.ApprovalModel;
import com.xy.wwoa.approval.api.WorkSummaryModal;
import com.xy.wwoa.approval.model.ApprovalProcess;
import com.xy.wwoa.approval.model.WorkSummary;
import com.xy.wwoa.approval.service.ApprovalProcessService;
import com.xy.wwoa.approval.service.WorkSummaryService;
import com.xy.wwoa.approval.util.ApprovalUtil;
import com.xy.wwoa.common.util.SpringBeanUtil;
import com.xy.wwoa.employee.mapper.EmployeeMapper;
import com.xy.wwoa.employee.mapper.OrganizationMapper;
import com.xy.wwoa.employee.mapper.ProvinceMapper;
import com.xy.wwoa.employee.model.Employee;

import javax.annotation.Resource;

/**
 * @Author 陈璇
 * @Description WorkSummaryStrategy
 * @date 2019/8/31 17:14
 */
public class WorkSummaryStrategy implements ApprovalStrategy{

    private ProvinceMapper provinceMapper = SpringBeanUtil.getBean(ProvinceMapper.class);

    private OrganizationMapper organizationMapper = SpringBeanUtil.getBean(OrganizationMapper.class);

    private WorkSummaryService workSummaryService = SpringBeanUtil.getBean(WorkSummaryService.class);

    @Override
    public ApprovalModel buildApprovalModel(String approvalNumber, Integer approvalTypeId) {
        WorkSummary workSummary = workSummaryService.getByApprovalNumber(approvalNumber);
        ApprovalModel approvalModel = ApprovalModel.builder()
                .approvalNumber(workSummary.getApprovalNumber())
                .approvalTypeId(approvalTypeId)
                .createUserName(workSummary.getCreateUserName())
                .title(workSummary.getCreateUserName() + "提交的工作报告")
                .subTitle1("工作内容: " + workSummary.getWorkContent())
                .createUser(workSummary.getCreateUser())
                .createTime(workSummary.getCreateTime())
                .build();
        return approvalModel;
    }

    @Override
    public ApprovalDetail buildApprovalDetail(String approvalNumber, Integer approvalTypeId) {
        WorkSummary workSummary = workSummaryService.getByApprovalNumber(approvalNumber);
        WorkSummaryModal workSummaryModal = WorkSummaryModal.builder()
                .approvalNumber(workSummary.getApprovalNumber())
                .jobName(provinceMapper.findById(workSummary.getEmployee().getJobId()).getProvinceName())
                .organizationName(organizationMapper.findById(workSummary.getEmployee().getOrganizationId()).getOrganizationName())
                .telephone(workSummary.getEmployee().getTelephone())
                .workContent(workSummary.getWorkContent())
                .build();
        ApprovalDetail approvalDetail = ApprovalDetail.builder()
                .createUser(workSummary.getCreateUser())
                .createUserName(workSummary.getCreateUserName())
                .createTime(workSummary.getCreateTime())
                .ccIds(workSummary.getCcIds())
                .approvalContent(workSummaryModal)
                .build();
        return approvalDetail;
    }

    @Override
    public void approved(String approvalNumber) {

    }
}
