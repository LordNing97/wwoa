package com.xy.wwoa.approval.service;

import cn.hutool.core.bean.BeanUtil;
import com.xy.wwoa.approval.api.BecomeWorkerList;
import com.xy.wwoa.approval.api.BecomeWorkerModal;
import com.xy.wwoa.approval.exception.ApprovalException;
import com.xy.wwoa.approval.mapper.BecomeWorkerMapper;
import com.xy.wwoa.approval.model.BecomeWorker;
import com.xy.wwoa.approval.request.SaveBecomeWorkerRequest;
import com.xy.wwoa.approval.util.ApprovalNumberDevice;
import com.xy.wwoa.common.util.CommonUtil;
import com.xy.wwoa.employee.mapper.EmployeeInformationMapper;
import com.xy.wwoa.employee.mapper.EmployeeMapper;
import com.xy.wwoa.employee.mapper.OrganizationMapper;
import com.xy.wwoa.employee.mapper.ProvinceMapper;
import com.xy.wwoa.employee.model.Employee;
import com.xy.wwoa.employee.model.EmployeeInformation;
import com.xy.wwoa.setting.mapper.ContractTypeMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author 陈璇
 * @Description BecomeWorkerService
 * @date 2019/9/2 16:10
 */
@Service
public class BecomeWorkerService {

    @Resource
    private BecomeWorkerMapper becomeWorkerMapper;

    @Resource
    private EmployeeMapper employeeMapper;

    @Resource
    private EmployeeInformationMapper employeeInformationMapper;

    @Resource
    private OrganizationMapper organizationMapper;

    @Resource
    private ProvinceMapper provinceMapper;

    @Resource
    private ContractTypeMapper contractTypeMapper;

    @Resource
    private CcService ccService;

    @Transactional
    public void save(String approvalNumber) {
        BecomeWorker becomeWorker = new BecomeWorker();
        becomeWorker.setApprovalNumber(approvalNumber);
        becomeWorker.setStatus(-1);
        becomeWorkerMapper.save(becomeWorker);
    }

    /**
     * 添加转正信息
     */
    @Transactional
    public void save(Integer employeeId, SaveBecomeWorkerRequest saveBecomeWorkerRequest, Integer approvalTypeId) {
        if (saveBecomeWorkerRequest.getEmployeeStatus() != 0) {
            BecomeWorker becomeWorker = becomeWorkerMapper.findByApprovalNumber(saveBecomeWorkerRequest.getApprovalNumber());
            if (becomeWorker.getStatus() != -1) {
                throw new ApprovalException("该转正信息已提交过审批");
            }
            Employee employee = employeeMapper.findById(employeeId);
            //获取所有人事
            String ids = employeeMapper.findAllPersonnelMatters(employee.getOrganizationId());
            //添加转正信息

            BeanUtil.copyProperties(saveBecomeWorkerRequest, becomeWorker);
            becomeWorker.setApprovalNumber(saveBecomeWorkerRequest.getApprovalNumber());
            becomeWorker.setCreateUser(employee.getId());
            becomeWorker.setCreateTime(LocalDateTime.now());
            becomeWorker.setCcIds(ids);
            becomeWorker.setStatus(0);
            becomeWorkerMapper.modify(becomeWorker);
            //修改员工基本信息
            EmployeeInformation employeeInformation = employeeInformationMapper.findByEmployeeId(saveBecomeWorkerRequest.getEmployeeId());
            employeeInformation.setPositiveTime(saveBecomeWorkerRequest.getPositiveTime());
            employeeInformation.setEmployeeStatus(saveBecomeWorkerRequest.getEmployeeStatus());
            employeeInformation.setCurrentSalary(employeeInformation.getFormalSalary());
            employeeInformation.setMaturityTime(employeeInformation.getEntryTime().plusYears(employeeInformation.getContractTime()));
            employeeInformationMapper.updateEmployeeBecomeWorker(employeeInformation);
            //修改员工职位
            employeeMapper.updateEmployeeBecomeWorker(saveBecomeWorkerRequest.getEmployeeId(), saveBecomeWorkerRequest.getJobId());
            //添加抄送信息
            ccService.save(saveBecomeWorkerRequest.getApprovalNumber(), approvalTypeId, ids.split(","));
        }
    }

    /**
     * 判断员工是否转正
     */
    public int isPositive(Integer employeeId) {
        EmployeeInformation employeeInformation = employeeInformationMapper.findByEmployeeId(employeeId);
        int employeeStatus = employeeInformation.getEmployeeStatus();
        return employeeStatus;
    }

    /**
     * 根据审批编号查询
     */
    public BecomeWorker getByApprovalNumber(String approvalNumber) {
        BecomeWorker becomeWorker = becomeWorkerMapper.findByApprovalNumber(approvalNumber);
        Employee employee = employeeMapper.findById(becomeWorker.getEmployeeId());
        EmployeeInformation employeeInformation = employeeInformationMapper.findByEmployeeId(becomeWorker.getEmployeeId());
        becomeWorker.setEmployee(employee);
        becomeWorker.setEmployeeInformation(employeeInformation);
        return becomeWorker;
    }

    /**
     * 分页获取转正信息
     */
    public BecomeWorkerList listBecomeWorker(Integer organizationId, Integer jobId, String employeeName, String idcard, Integer page, Integer size) {
        long total = becomeWorkerMapper.countBecomeWorker(organizationId, jobId, employeeName, idcard);
        List<BecomeWorker> becomeWorkerList = becomeWorkerMapper.listBecomeWorker(organizationId, jobId, employeeName, idcard, (page - 1) * size, page * size);

        List<BecomeWorkerModal> becomeWorkerModalList = becomeWorkerList.stream().map(becomeWorker -> {
            Employee employee = employeeMapper.findById(becomeWorker.getEmployeeId());
            EmployeeInformation employeeInformation = employeeInformationMapper.findByEmployeeId(becomeWorker.getEmployeeId());
            BecomeWorkerModal becomeWorkerModal = BecomeWorkerModal.builder()
                    .approvalNumber(becomeWorker.getApprovalNumber())
                    .actualApplicantName(employee.getEmployeeName())
                    .organizationName(organizationMapper.findById(employee.getOrganizationId()).getOrganizationName())
                    .oldJobName(provinceMapper.findById(employeeInformation.getJobId()).getProvinceName())
                    .newJobName(provinceMapper.findById(employee.getJobId()).getProvinceName())
                    .probationTime(employeeInformation.getEntryTime().plusMonths(employeeInformation.getProbationTime()))
                    .formalSalary(employeeInformation.getFormalSalary())
                    .workShow(becomeWorker.getWorkShow())
                    .performance(becomeWorker.getPerformance())
                    .remark(CommonUtil.fillNull(becomeWorker.getRemark()))
                    .idcard(employee.getIdcard())
                    .build();
            return becomeWorkerModal;
        }).collect(Collectors.toList());

        return BecomeWorkerList.builder()
                .list(becomeWorkerModalList)
                .page(page)
                .total(total)
                .build();
    }

    /**
     * 获取转正审批详情信息
     */
    public BecomeWorkerModal detailedInformation(Integer id) {
        BecomeWorker becomeWorker = becomeWorkerMapper.findById(id);
        EmployeeInformation employeeInformation = employeeInformationMapper.findByEmployeeId(becomeWorker.getEmployeeId());
        BecomeWorkerModal becomeWorkerModal = BecomeWorkerModal.builder()
                .organizationName(organizationMapper.findById(employeeInformation.getOrganizationId()).getOrganizationName())
                .takeOfficeCity(employeeInformation.getTakeOfficeCity())
                .telephone(employeeInformation.getTelephone())
                .probationSalary(employeeInformation.getProbationSalary())
                .insuranceCardinalNumber(employeeInformation.getInsuranceCardinalNumber())
                .maturityTime(employeeInformation.getMaturityTime())
                .jobName(provinceMapper.findById(employeeInformation.getJobId()).getProvinceName())
                .entryTime(employeeInformation.getEntryTime())
                .probationDate(employeeInformation.getProbationTime())
                .formalSalary(employeeInformation.getFormalSalary())
                .contractTypeName(contractTypeMapper.findById(employeeInformation.getContractTypeId()).getName())
                .build();
        return becomeWorkerModal;
    }

}
