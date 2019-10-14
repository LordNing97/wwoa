package com.xy.wwoa.approval.strategy;

import com.xy.wwoa.approval.api.ApprovalDetail;
import com.xy.wwoa.approval.api.ApprovalModel;
import com.xy.wwoa.approval.api.PerformanceAppraisalModal;
import com.xy.wwoa.approval.model.ApprovalProcess;
import com.xy.wwoa.approval.model.PerformanceAppraisal;
import com.xy.wwoa.approval.service.ApprovalProcessService;
import com.xy.wwoa.approval.service.PerformanceAppraisalService;
import com.xy.wwoa.approval.util.ApprovalUtil;
import com.xy.wwoa.common.util.SpringBeanUtil;
import com.xy.wwoa.employee.mapper.OrganizationMapper;

/**
 * @Author 陈璇
 * @Description PerformanceAppraisalStrategy
 * @date 2019/8/31 16:45
 */
public class PerformanceAppraisalStrategy implements ApprovalStrategy{

    private PerformanceAppraisalService performanceAppraisalService = SpringBeanUtil.getBean(PerformanceAppraisalService.class);

    private OrganizationMapper organizationMapper = SpringBeanUtil.getBean(OrganizationMapper.class);

    private ApprovalProcessService approvalProcessService = SpringBeanUtil.getBean(ApprovalProcessService.class);

    @Override
    public ApprovalModel buildApprovalModel(String approvalNumber, Integer approvalTypeId) {
        PerformanceAppraisal performanceAppraisal = performanceAppraisalService.getByApprovalNumber(approvalNumber);
        ApprovalProcess last = approvalProcessService.getLast(approvalNumber);
        ApprovalModel approvalModel = ApprovalModel.builder()
                .approvalNumber(performanceAppraisal.getApprovalNumber())
                .approvalTypeId(approvalTypeId)
                .createUserName(performanceAppraisal.getCreateUserName())
                .title(performanceAppraisal.getCreateUserName() + "提交的绩效自评")
                .subTitle1("上月工作任务: " + performanceAppraisal.getLastWorkTask())
                .subTitle2("实际完成任务: " + performanceAppraisal.getRealityWorkTask())
                .subTitle3("任务完成率: " + performanceAppraisal.getTaskCompleteRate())
                .createUser(performanceAppraisal.getCreateUser())
                .createTime(performanceAppraisal.getCreateTime())
                .approverId(last.getApproverId())
                .status(last.getStatus())
                .state(ApprovalUtil.approvalStatusStr(last.getStatus(), last.getApproverName()))
                .build();
        return approvalModel;
    }

    @Override
    public ApprovalDetail buildApprovalDetail(String approvalNumber, Integer approvalTypeId) {
        PerformanceAppraisal performanceAppraisal = performanceAppraisalService.getByApprovalNumber(approvalNumber);
        PerformanceAppraisalModal performanceAppraisalModal = PerformanceAppraisalModal.builder()
                .approvalNumber(performanceAppraisal.getApprovalNumber())
                .organizationName(organizationMapper.findById(performanceAppraisal.getEmployee().getOrganizationId()).getOrganizationName())
                .lastWorkTask(performanceAppraisal.getLastWorkTask())
                .realityWorkTask(performanceAppraisal.getRealityWorkTask())
                .taskCompleteRate(performanceAppraisal.getTaskCompleteRate())
                .lastWorkAppraisal(performanceAppraisal.getLastWorkAppraisal())
                .workTask(performanceAppraisal.getWorkTask())
                .workPlan(performanceAppraisal.getWorkPlan())
                .build();
        ApprovalDetail approvalDetail = ApprovalDetail.builder()
                .createUser(performanceAppraisal.getCreateUser())
                .createUserName(performanceAppraisal.getCreateUserName())
                .createTime(performanceAppraisal.getCreateTime())
                .ccIds(performanceAppraisal.getCcIds())
                .approvalContent(performanceAppraisalModal)
                .build();
        return approvalDetail;
    }

    @Override
    public void approved(String approvalNumber) {

    }
}
