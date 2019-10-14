package com.xy.wwoa.approval.service;

import com.xy.wwoa.approval.api.PerformanceAppraisalList;
import com.xy.wwoa.approval.api.PerformanceAppraisalModal;
import com.xy.wwoa.approval.api.PerformanceAppraisalProcessesModal;
import com.xy.wwoa.approval.mapper.ApprovalProcessMapper;
import com.xy.wwoa.approval.mapper.PerformanceAppraisalMapper;
import com.xy.wwoa.approval.model.ApprovalProcess;
import com.xy.wwoa.approval.model.PerformanceAppraisal;
import com.xy.wwoa.approval.util.ApprovalNumberDevice;
import com.xy.wwoa.approval.util.ApprovalUtil;
import com.xy.wwoa.employee.mapper.EmployeeMapper;
import com.xy.wwoa.employee.mapper.OrganizationMapper;
import com.xy.wwoa.employee.model.Employee;
import com.xy.wwoa.employee.model.EmployeeInformation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author 陈璇
 * @Description PerformanceAppraisalService
 * @date 2019/8/31 11:58
 */
@Service
public class PerformanceAppraisalService {

    @Resource
    private PerformanceAppraisalMapper performanceAppraisalMapper;

    @Resource
    private EmployeeMapper employeeMapper;

    @Resource
    private OrganizationMapper organizationMapper;

    @Resource
    private ApprovalProcessMapper approvalProcessMapper;

    @Resource
    private ApprovalProcessService approvalProcessService;

    /**
     * 添加绩效自评审核信息
     */
    @Transactional
    public void save(Employee employee, PerformanceAppraisal performanceAppraisal, Integer approvalTypeId){
        //生成审批编号
        String approvalNumber = ApprovalNumberDevice.createApprovalNumber();
        //修改绩效自评审核信息
        performanceAppraisal.setApprovalNumber(approvalNumber);
        performanceAppraisal.setEmployeeId(employee.getId());
        performanceAppraisal.setOrganizationId(employee.getOrganizationId());
        performanceAppraisal.setJobId(employee.getJobId());
        performanceAppraisal.setCreateUser(employee.getId());
        performanceAppraisal.setCreateTime(LocalDateTime.now());
        performanceAppraisal.setStatus(0);
        //保存绩效自评审核信息
        performanceAppraisalMapper.save(performanceAppraisal);
        //保存审批流程信息
        approvalProcessService.save(employee.getId(),approvalNumber,performanceAppraisal.getApproverIds(),approvalTypeId);
    }

    /**
     * 根据审批编号查询
     */
    public PerformanceAppraisal getByApprovalNumber(String approvalNumber) {
        PerformanceAppraisal performanceAppraisal = performanceAppraisalMapper.findByApprovalNumber(approvalNumber);
        Employee employee = employeeMapper.findById(performanceAppraisal.getCreateUser());
        performanceAppraisal.setEmployee(employee);
        return performanceAppraisal;
    }

    /**
     * 分页获取绩效自评审核信息
     */
    public PerformanceAppraisalList listPerformanceAppraisal(Integer organizationId, String employeeName,Integer page,Integer size){
        long total = performanceAppraisalMapper.countPerformanceAppraisal(organizationId,employeeName);
        List<PerformanceAppraisal> performanceAppraisalList = performanceAppraisalMapper.listPerformanceAppraisal(organizationId, employeeName, (page - 1) * size,page * size);

        List<PerformanceAppraisalModal> performanceAppraisalModalList = performanceAppraisalList.stream().map(performanceAppraisal -> {
            Employee employee = employeeMapper.findById(performanceAppraisal.getCreateUser());
            PerformanceAppraisalModal performanceAppraisalModal = PerformanceAppraisalModal.builder()
                    .approvalNumber(performanceAppraisal.getApprovalNumber())
                    .id(performanceAppraisal.getId())
                    .organizationName(organizationMapper.findById(employee.getOrganizationId()).getOrganizationName())
                    .employeeName(employee.getEmployeeName())
                    .createTime(performanceAppraisal.getCreateTime())
                    .realityWorkTask(performanceAppraisal.getRealityWorkTask())
                    .workTask(performanceAppraisal.getWorkTask())
                    .taskCompleteRate(performanceAppraisal.getTaskCompleteRate())
                    .build();
            return performanceAppraisalModal;
        }).collect(Collectors.toList());

        return PerformanceAppraisalList.builder()
                .list(performanceAppraisalModalList)
                .page(page)
                .total(total)
                .build();
    }

    /**
     * 绩效审批详情信息
     */
    public PerformanceAppraisalModal detailedInformation(Integer id){
        PerformanceAppraisal performanceAppraisal = performanceAppraisalMapper.findById(id);
        Employee employee = employeeMapper.findById(performanceAppraisal.getCreateUser());
//        List<ApprovalProcess> approvalProcessList = approvalProcessMapper.findByApprovalNumber(performanceAppraisal.getApprovalNumber());
//        List<PerformanceAppraisalProcessesModal> performanceAppraisalProcessesModalList = new ArrayList<>(approvalProcessList.size() + 1);
//        PerformanceAppraisalProcessesModal performanceAppraisalProcessesModal = PerformanceAppraisalProcessesModal.builder()
//                .employeeName(employee.getEmployeeName())
//                .approvalTime(performanceAppraisal.getCreateTime())
//                .status(-1)
//                .state("发起申请")
//                .build();
//        performanceAppraisalProcessesModalList.add(performanceAppraisalProcessesModal);
//        for(ApprovalProcess approvalProcess:approvalProcessList){
//            PerformanceAppraisalProcessesModal performanceAppraisalProcessesModal1 = PerformanceAppraisalProcessesModal.builder()
//                    .employeeName(employeeMapper.findById(approvalProcess.getApproverId()).getEmployeeName())
//                    .approvalTime(approvalProcess.getApprovalTime())
//                    .status(approvalProcess.getStatus())
//                    .state(ApprovalUtil.approvalDetailStatusStr(approvalProcess.getStatus()))
//                    .approvalOpinion(approvalProcess.getApprovalOpinion())
//                    .build();
//            performanceAppraisalProcessesModalList.add(performanceAppraisalProcessesModal1);
//            if(approvalProcess.getLatest() == 1){
//                break;
//            }
//        }

        PerformanceAppraisalModal performanceAppraisalModal = PerformanceAppraisalModal.builder()
                .organizationName(organizationMapper.findById(employee.getOrganizationId()).getOrganizationName())
                .createTime(performanceAppraisal.getCreateTime())
                .realityWorkTask(performanceAppraisal.getRealityWorkTask())
                .lastWorkAppraisal(performanceAppraisal.getLastWorkAppraisal())
                .workPlan(performanceAppraisal.getWorkPlan())
                .employeeName(employee.getEmployeeName())
                .lastWorkTask(performanceAppraisal.getLastWorkTask())
                .taskCompleteRate(performanceAppraisal.getTaskCompleteRate())
                .workTask(performanceAppraisal.getWorkTask())
                .approvalNumber(performanceAppraisal.getApprovalNumber())
                .build();
        return performanceAppraisalModal;
    }

}
