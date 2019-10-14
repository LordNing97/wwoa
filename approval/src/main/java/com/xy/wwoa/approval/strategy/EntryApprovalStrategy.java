package com.xy.wwoa.approval.strategy;

import com.xy.wwoa.approval.api.ApprovalDetail;
import com.xy.wwoa.approval.api.ApprovalModel;
import com.xy.wwoa.approval.api.EntryApprovalModel;
import com.xy.wwoa.approval.model.ApprovalProcess;
import com.xy.wwoa.approval.model.EntryApproval;
import com.xy.wwoa.approval.service.ApprovalProcessService;
import com.xy.wwoa.approval.service.EntryApprovalService;
import com.xy.wwoa.approval.util.ApprovalUtil;
import com.xy.wwoa.common.util.SpringBeanUtil;
import com.xy.wwoa.employee.api.EmployeeInformationModel;
import com.xy.wwoa.employee.model.EmployeeInformation;
import com.xy.wwoa.employee.service.EmployeeInformationService;

/**
 * @Author leisurexi
 * @Description 入职审批策略实现类
 * @Date 2019/8/31
 * @Time 11:50
 */
public class EntryApprovalStrategy implements ApprovalStrategy {

    private EntryApprovalService entryApprovalService = SpringBeanUtil.getBean(EntryApprovalService.class);
    private EmployeeInformationService employeeInformationService = SpringBeanUtil.getBean(EmployeeInformationService.class);
    private ApprovalProcessService approvalProcessService = SpringBeanUtil.getBean(ApprovalProcessService.class);

    @Override
    public ApprovalModel buildApprovalModel(String approvalNumber, Integer approvalTypeId) {
        EntryApproval entryApproval = entryApprovalService.getByApprovalNumber(approvalNumber, approvalTypeId);
        ApprovalProcess last = approvalProcessService.getLast(approvalNumber);
        ApprovalModel approvalModel = ApprovalModel.builder()
                .approvalNumber(entryApproval.getApprovalNumber())
                .approvalTypeId(approvalTypeId)
                .approverId(last.getApproverId())
                .createUserName(entryApproval.getCreateUserName())
                .title(entryApproval.getCreateUserName() + "提交的入职")
                .subTitle1("工作部门: " + entryApproval.getEmployeeInformation().getOrganizationName())
                .subTitle2("工作岗位: " + entryApproval.getEmployeeInformation().getJobName())
                .subTitle3("就职城市: " + entryApproval.getEmployeeInformation().getTakeOfficeCity())
                .createUser(entryApproval.getCreateUser())
                .createTime(entryApproval.getCreateTime())
                .status(last.getStatus())
                .state(ApprovalUtil.approvalStatusStr(last.getStatus(), last.getApproverName()))
                .build();
        return approvalModel;
    }

    @Override
    public ApprovalDetail buildApprovalDetail(String approvalNumber, Integer approvalTypeId) {
        EntryApproval entryApproval = entryApprovalService.getByApprovalNumber(approvalNumber, approvalTypeId);
        EmployeeInformation information = entryApproval.getEmployeeInformation();
        EmployeeInformationModel employeeInformationModel = EmployeeInformationModel.builder()
                .sex(information.getSex())
                .nation(information.getNation())
                .birthday(information.getBirthday())
                .idCard(information.getIdCard())
                .registeredResidence(information.getRegisteredResidence())
                .politicalAppearance(information.getPoliticalAppearance())
                .maritalStatus(information.getMaritalStatus())
                .weixinNo(information.getWeixinNo())
                .email(information.getEmail())
                .emergencyContactName(information.getEmergencyContactName())
                .emergencyContactPhone(information.getEmergencyContactPhone())
                .familyAddress(information.getFamilyAddress())
                .presentAddress(information.getPresentAddress())
                .selfEvaluation(information.getSelfEvaluation())
                .certificateAndSkills(information.getCertificateAndSkills())
                .educationStatuses(information.getEducationStatuses())
                .familyStatuses(information.getFamilyStatuses())
                .jobResumes(information.getJobResumes())
                .build();

        EntryApprovalModel entryApprovalModel = EntryApprovalModel.builder()
                .approvalNumber(entryApproval.getApprovalNumber())
                .employeeName(information.getName())
                .organizationName(information.getOrganizationName())
                .jobName(information.getJobName())
                .telephone(information.getTelephone())
                .entryTime(information.getEntryTime())
                .employeeInformationModel(employeeInformationModel)
                .build();

        ApprovalDetail approvalDetail = ApprovalDetail.builder()
                .createUser(entryApproval.getCreateUser())
                .createUserName(entryApproval.getCreateUserName())
                .createTime(entryApproval.getCreateTime())
                .ccIds(entryApproval.getCcIds())
                .approvalContent(entryApprovalModel)
                .build();
        return approvalDetail;
    }

    @Override
    public void approved(String approvalNumber) {
        EntryApproval entryApproval = entryApprovalService.getByApprovalNumber(approvalNumber, null);
        //将员工基本信息改为正常状态
        employeeInformationService.modifyStatus(entryApproval.getEmployeeInformationId(), 1);
    }

}
