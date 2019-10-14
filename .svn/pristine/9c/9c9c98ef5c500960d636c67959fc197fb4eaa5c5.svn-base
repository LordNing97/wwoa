package com.xy.wwoa.approval.service;

import com.xy.wwoa.approval.api.WorkSummaryList;
import com.xy.wwoa.approval.api.WorkSummaryModal;
import com.xy.wwoa.approval.mapper.CcMapper;
import com.xy.wwoa.approval.mapper.WorkSummaryMapper;
import com.xy.wwoa.approval.model.Cc;
import com.xy.wwoa.approval.model.WorkSummary;
import com.xy.wwoa.approval.util.ApprovalNumberDevice;
import com.xy.wwoa.employee.mapper.EmployeeMapper;
import com.xy.wwoa.employee.mapper.OrganizationMapper;
import com.xy.wwoa.employee.model.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @Author 陈璇
 * @Description WorkSummaryService
 * @date 2019/8/31 17:00
 */
@Service
public class WorkSummaryService {

    @Resource
    private WorkSummaryMapper workSummaryMapper;

    @Resource
    private EmployeeMapper employeeMapper;

    @Resource
    private OrganizationMapper organizationMapper;

    @Resource
    private CcService ccService;

    /**
     * 添加工作总结信息
     */
    @Transactional
    public void save(Employee employee, WorkSummary workSummary,Integer approvalTypeId){
        //生成审批编号
        String approvalNumber = ApprovalNumberDevice.createApprovalNumber();
        //修改离职审批信息
        workSummary.setOrganizationId(employee.getOrganizationId());
        workSummary.setJobId(employee.getJobId());
        workSummary.setApprovalNumber(approvalNumber);
        workSummary.setEmployeeId(employee.getId());
        workSummary.setCreateUser(employee.getId());
        workSummary.setCreateTime(LocalDateTime.now());
        workSummary.setStatus(0);
        //保存离职审批信息
        workSummaryMapper.save(workSummary);
        //保存抄送信息
        if(!StringUtils.isEmpty(workSummary.getCcIds())){
            ccService.save(approvalNumber, approvalTypeId, workSummary.getCcIds().split(","));
        }
    }

    /**
     * 根据审批编号查询
     */
    public WorkSummary getByApprovalNumber(String approvalNumber) {
        WorkSummary workSummary = workSummaryMapper.findByApprovalNumber(approvalNumber);
        workSummary.setEmployee(employeeMapper.findById(workSummary.getEmployeeId()));
        return workSummary;
    }

    /**
     * 分页获取工作总结信息
     */
    public WorkSummaryList listWorkSummary(Integer organizationId, String employeeName,String workContent,Integer page,Integer size){
        long total = workSummaryMapper.countWorkSummary(organizationId, employeeName, workContent);
        List<WorkSummary> workSummaryList = workSummaryMapper.listWorkSummary(organizationId, employeeName, workContent, (page - 1) * page, page * size);

        List<WorkSummaryModal> workSummaryModalList = workSummaryList.stream().map(workSummary -> {
            Employee employee = employeeMapper.findById(workSummary.getCreateUser());
            WorkSummaryModal workSummaryModal = WorkSummaryModal.builder()
                    .approvalNumber(workSummary.getApprovalNumber())
                    .organizationName(organizationMapper.findById(employee.getOrganizationId()).getOrganizationName())
                    .employeeName(employee.getEmployeeName())
                    .createTime(workSummary.getCreateTime())
                    .workContent(workSummary.getWorkContent())
                    .build();
            return workSummaryModal;
        }).collect(Collectors.toList());

        return WorkSummaryList.builder()
                .list(workSummaryModalList)
                .page(page)
                .total(total)
                .build();
    }

    /**
     * 工作总结审批详细信息
     */
    public WorkSummaryModal detailedInformation(Integer id){
        WorkSummary workSummary = workSummaryMapper.findById(id);
        Employee employee = employeeMapper.findById(workSummary.getCreateUser());
        WorkSummaryModal workSummaryModal = WorkSummaryModal.builder()
                .organizationName(organizationMapper.findById(employee.getOrganizationId()).getOrganizationName())
                .employeeName(employee.getEmployeeName())
                .createTime(workSummary.getCreateTime())
                .workContent(workSummary.getWorkContent())
                .build();
        return workSummaryModal;
    }

}
