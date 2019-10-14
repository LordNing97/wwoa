package com.xy.wwoa.approval.service;

import com.xy.wwoa.approval.api.LeaveApprovalList;
import com.xy.wwoa.approval.api.LeaveApprovalModal;
import com.xy.wwoa.approval.mapper.LeaveApprovalMapper;
import com.xy.wwoa.approval.model.LeaveApproval;
import com.xy.wwoa.approval.util.ApprovalNumberDevice;
import com.xy.wwoa.approval.util.ApprovalUtil;
import com.xy.wwoa.common.util.CommonUtil;
import com.xy.wwoa.employee.mapper.EmployeeInformationMapper;
import com.xy.wwoa.employee.mapper.EmployeeMapper;
import com.xy.wwoa.employee.model.Employee;
import com.xy.wwoa.employee.model.EmployeeInformation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @Author 陈璇
 * @Description LeaveApprovalService
 * @date 2019/8/31 9:42
 */
@Service
public class LeaveApprovalService {

    @Resource
    private LeaveApprovalMapper leaveApprovalMapper;

    @Resource
    private EmployeeMapper employeeMapper;

    @Resource
    private EmployeeInformationMapper employeeInformationMapper;

    @Resource
    private ApprovalProcessService approvalProcessService;

    /**
     * 添加员工离职审批信息
     */
    @Transactional
    public void save(Integer employeeId, LeaveApproval leaveApproval, Integer approvalTypeId){
        //生成审批编号
        String approvalNumber = ApprovalNumberDevice.createApprovalNumber();
        //修改离职审批信息
        leaveApproval.setApprovalNumber(approvalNumber);
        leaveApproval.setCreateUser(employeeId);
        leaveApproval.setCreateTime(LocalDateTime.now());
        leaveApproval.setStatus(0);
        //保存离职审批信息
        leaveApprovalMapper.save(leaveApproval);
        //保存审批流程信息
        approvalProcessService.save(employeeId,approvalNumber,leaveApproval.getApproverIds(),approvalTypeId);
    }

    /**
     * 根据审批编号查询
     */
    public LeaveApproval getByApprovalNumber(String approvalNumber) {
        LeaveApproval leaveApproval = leaveApprovalMapper.findByApprovalNumber(approvalNumber);
        Employee employee = employeeMapper.findById(leaveApproval.getActualApplicantId());
        EmployeeInformation employeeInformation = employeeInformationMapper.findByEmployeeId(leaveApproval.getActualApplicantId());
        leaveApproval.setActualApplicant(employee);
        leaveApproval.setActualApplicantInformation(employeeInformation);
        return leaveApproval;
    }

    /**
     *  分页获取员工离职审批信息
     */
    public LeaveApprovalList listLeaveApproval(Integer organizationId, Integer jobId, String employeeName, String idcard, Integer status, Integer page, Integer size){
        List<LeaveApproval> leaveApprovalList = leaveApprovalMapper.listLeaveApproval(organizationId, jobId, employeeName, idcard, status, (page - 1) * size, page * size);
        long total = leaveApprovalMapper.countLeaveApproval(organizationId, jobId, employeeName, idcard, status);

        List<LeaveApprovalModal> leaveApprovalModalList = leaveApprovalList.stream().map(leaveApproval -> {
            Employee employee = employeeMapper.findById(leaveApproval.getActualApplicantId());
            EmployeeInformation employeeInformation = employeeInformationMapper.findByEmployeeId(leaveApproval.getActualApplicantId());
            Period period = Period.between(employeeInformation.getEntryTime().toLocalDate(), leaveApproval.getLeavingTime().toLocalDate());
            long workDays = period.getYears() * 12 + period.getMonths();
            LeaveApprovalModal leaveApprovalModal = LeaveApprovalModal.builder()
                    .approvalNumber(leaveApproval.getApprovalNumber())
                    .employeeName(employeeInformation.getName())
                    .idcard(employeeInformation.getIdCard())
                    .organizationName(employeeInformation.getOrganizationName())
                    .jobName(employeeInformation.getJobName())
                    .entryTime(employeeInformation.getEntryTime())
                    .workAge(workDays)
                    .leavingReason(leaveApproval.getLeavingReason())
                    .leavingTime(leaveApproval.getLeavingTime())
                    .workHandover(ApprovalUtil.workHandoverStr(leaveApproval.getWorkHandover()))
                    .workHandoverEmployeeName(employeeMapper.findById(leaveApproval.getWorkHandoverEmployee()).getEmployeeName())
                    .status(ApprovalUtil.approvalStatusStr(leaveApproval.getStatus()))
                    .remark(CommonUtil.fillNull(leaveApproval.getRemark()))
                    .build();
            return leaveApprovalModal;
        }).collect(Collectors.toList());

        return LeaveApprovalList.builder()
                .list(leaveApprovalModalList)
                .page(page)
                .total(total)
                .build();
    }

    //员工离职
    public void employeeTurnover(Integer employeeId){
        employeeMapper.modifyStatus(employeeId,3);
        employeeInformationMapper.modifyEmployeeStatus(employeeId,2);
    }

}
