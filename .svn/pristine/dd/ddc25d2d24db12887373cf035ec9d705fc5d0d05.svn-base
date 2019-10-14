package com.xy.wwoa.approval.service;

import com.xy.wwoa.approval.api.RenewApprovalList;
import com.xy.wwoa.approval.api.RenewApprovalModel;
import com.xy.wwoa.approval.exception.ApprovalException;
import com.xy.wwoa.approval.mapper.RenewApprovalMapper;
import com.xy.wwoa.approval.model.RenewApproval;
import com.xy.wwoa.approval.util.ApprovalUtil;
import com.xy.wwoa.employee.model.Employee;
import com.xy.wwoa.employee.service.EmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: leisurexi
 * Date: 2019-08-27
 * Time: 21:56
 */
@Service
public class RenewApprovalService {

    @Resource
    private RenewApprovalMapper renewApprovalMapper;

    @Resource
    private ApprovalProcessService approvalProcessService;

    @Resource
    private EmployeeService employeeService;

    public RenewApproval getByApprovalNumber(String approvalNumber) {
        return renewApprovalMapper.findByApprovalNumber(approvalNumber);
    }

    @Transactional
    public void save(String approvalNumber) {
        RenewApproval renewApproval = new RenewApproval();
        renewApproval.setApprovalNumber(approvalNumber);
        renewApproval.setStatus(-1);
        renewApprovalMapper.save(renewApproval);
    }

    /**
     * 保存合同续签审批信息
     */
    @Transactional
    public boolean save(Integer employeeId, RenewApproval renewApproval, Integer approvalTypeId) {
        RenewApproval temp = renewApprovalMapper.findByApprovalNumber(renewApproval.getApprovalNumber());
        if (temp.getStatus() != -1) {
            throw new ApprovalException("该合同续签信息已提交过审批");
        }
        renewApproval.setApprovalNumber(renewApproval.getApprovalNumber());
        renewApproval.setCreateUser(employeeId);
        renewApproval.setCreateTime(LocalDateTime.now());
        renewApproval.setStatus(0);
        //保存审批信息
        renewApprovalMapper.modify(renewApproval);
        //保存审批流程信息
        approvalProcessService.save(employeeId, renewApproval.getApprovalNumber(), renewApproval.getApproverIds(), approvalTypeId);
        return true;
    }

    /**
     * 后台 人事管理-合同续签列表
     */
    public RenewApprovalList listContractApproval(Integer organizationId, Integer jobId, String employeeName, String telephone, Integer status, Integer page, Integer size) {
        List<RenewApproval> renewApprovalList = renewApprovalMapper.listContractApproval(organizationId, jobId, employeeName, telephone, status, (page - 1) * size, page * size);
        long total = renewApprovalMapper.countContractApproval(organizationId, jobId, employeeName, telephone, status);
        List<RenewApprovalModel> renewApprovalModelList = renewApprovalList.stream().map(renewApproval -> {
            Employee employee = employeeService.getById(renewApproval.getActualApplicantId());
            RenewApprovalModel approvalModel = RenewApprovalModel.builder()
                    .approvalNumber(renewApproval.getApprovalNumber())
                    .employeeName(employee.getEmployeeName())
                    .organizationName(employee.getOrganizationName())
                    .jobName(employee.getJobName())
                    .maturityTime(renewApproval.getMaturityTime())
                    .renewSalary(renewApproval.getRenewSalary())
                    .workShow(renewApproval.getWorkShow())
                    .performance(renewApproval.getPerformance())
                    .state(ApprovalUtil.approvalStatusStr(renewApproval.getStatus()))
                    .build();
            return approvalModel;
        }).collect(Collectors.toList());
        return RenewApprovalList.builder()
                .list(renewApprovalModelList)
                .page(page)
                .total(total)
                .build();
    }

}
