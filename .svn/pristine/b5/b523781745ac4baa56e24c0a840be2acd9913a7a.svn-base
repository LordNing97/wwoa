package com.xy.wwoa.approval.strategy;

import com.xy.wwoa.approval.api.ApprovalDetail;
import com.xy.wwoa.approval.api.ApprovalModel;
import com.xy.wwoa.approval.api.BecomeWorkerModal;
import com.xy.wwoa.approval.model.ApprovalProcess;
import com.xy.wwoa.approval.model.BecomeWorker;
import com.xy.wwoa.approval.service.ApprovalProcessService;
import com.xy.wwoa.approval.service.BecomeWorkerService;
import com.xy.wwoa.approval.util.ApprovalUtil;
import com.xy.wwoa.common.util.DateUtil;
import com.xy.wwoa.common.util.SpringBeanUtil;
import com.xy.wwoa.employee.mapper.OrganizationMapper;
import com.xy.wwoa.employee.mapper.ProvinceMapper;

import javax.annotation.Resource;

/**
 * @Author 陈璇
 * @Description BecomeWorkerStrategy
 * @date 2019/9/3 16:11
 */
public class BecomeWorkerStrategy implements ApprovalStrategy{

    private BecomeWorkerService becomeWorkerService = SpringBeanUtil.getBean(BecomeWorkerService.class);

    private ProvinceMapper provinceMapper = SpringBeanUtil.getBean(ProvinceMapper.class);

    private OrganizationMapper organizationMapper = SpringBeanUtil.getBean(OrganizationMapper.class);

    @Override
    public ApprovalModel buildApprovalModel(String approvalNumber, Integer approvalTypeId) {
        BecomeWorker becomeWorker = becomeWorkerService.getByApprovalNumber(approvalNumber);
        ApprovalModel approvalModel = ApprovalModel.builder()
                .approvalNumber(becomeWorker.getApprovalNumber())
                .approvalTypeId(approvalTypeId)
                .createUserName(becomeWorker.getCreateUserName())
                .title(becomeWorker.getCreateUserName() + "提交的转正")
                .subTitle1("转正岗位: " + provinceMapper.findById(becomeWorker.getEmployee().getJobId()).getProvinceName())
                .subTitle2("转正时间: " + DateUtil.convertDateToString(becomeWorker.getEmployeeInformation().getPositiveTime()))
                .subTitle3("工作表现: " + becomeWorker.getWorkShow())
                .createUser(becomeWorker.getCreateUser())
                .createTime(becomeWorker.getCreateTime())
                .build();
        return approvalModel;
    }

    @Override
    public ApprovalDetail buildApprovalDetail(String approvalNumber, Integer approvalTypeId) {
        BecomeWorker becomeWorker = becomeWorkerService.getByApprovalNumber(approvalNumber);
        BecomeWorkerModal becomeWorkerModal = BecomeWorkerModal.builder()
                .approvalNumber(becomeWorker.getApprovalNumber())
                .organizationName(organizationMapper.findById(becomeWorker.getEmployee().getOrganizationId()).getOrganizationName())
                .oldJobName(provinceMapper.findById(becomeWorker.getEmployeeInformation().getJobId()).getProvinceName())
                .newJobName(provinceMapper.findById(becomeWorker.getEmployee().getJobId()).getProvinceName())
                .telephone(becomeWorker.getEmployee().getTelephone())
                .positiveTime(becomeWorker.getEmployeeInformation().getPositiveTime())
                .actualApplicantName(becomeWorker.getEmployee().getEmployeeName())
                .workShow(becomeWorker.getWorkShow())
                .performance(becomeWorker.getPerformance())
                .entryTime(becomeWorker.getEmployeeInformation().getEntryTime())
                .build();
        ApprovalDetail approvalDetail = ApprovalDetail.builder()
                .createUser(becomeWorker.getCreateUser())
                .createUserName(becomeWorker.getCreateUserName())
                .createTime(becomeWorker.getCreateTime())
                .ccIds(becomeWorker.getCcIds())
                .approvalContent(becomeWorkerModal)
                .build();
        return approvalDetail;
    }

    @Override
    public void approved(String approvalNumber) {

    }

}
