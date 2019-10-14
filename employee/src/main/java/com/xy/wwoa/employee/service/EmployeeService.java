package com.xy.wwoa.employee.service;

import com.xy.wwoa.common.api.ResultCode;
import com.xy.wwoa.common.util.CommonUtil;
import com.xy.wwoa.employee.api.ApproverModel;
import com.xy.wwoa.employee.api.EmployeeModel;
import com.xy.wwoa.employee.api.EmployeeProvinceModel;
import com.xy.wwoa.employee.exception.LoginAccessException;
import com.xy.wwoa.employee.mapper.ApprovalEmployeeMapper;
import com.xy.wwoa.employee.mapper.EmployeeInformationMapper;
import com.xy.wwoa.employee.mapper.EmployeeMapper;
import com.xy.wwoa.employee.model.ApprovalEmployee;
import com.xy.wwoa.employee.model.Employee;
import com.xy.wwoa.employee.util.WechatUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author 陈璇
 * @Description EmployeeService
 * @date 2019/8/27 14:53
 */
@Service
public class EmployeeService {

    @Resource
    private EmployeeMapper employeeMapper;

    @Resource
    private ApprovalEmployeeMapper approvalEmployeeMapper;

    @Resource
    private EmployeeInformationMapper employeeInformationMapper;

    /**
     * 正常微信登录
     */
    public Employee login(String telephone, String password) {
        return employeeMapper.login(telephone, password);
    }

    /**
     * 正常微信登录
     */
    public Employee wechatLogin(String code) {
        String userId = WechatUtil.getUserId(code);
        return getEmployee(userId);
    }

    private Employee getEmployee(String userId) {
        Employee employee = employeeMapper.findById(Integer.valueOf(userId));
        if (employee == null) {
            throw new LoginAccessException(ResultCode.UN_REGISTER);
        }
        return employee;
    }

    /**
     * 根据部门和岗位获取员工信息
     */
    public EmployeeProvinceModel listEmployeeForJob(Integer organizationId) {
        EmployeeProvinceModel model = EmployeeProvinceModel.builder()
                .manager(convertEmployeeToEmployeeModel(employeeMapper.findAllByJobIdAndOrganizationId(24, organizationId)))
                .leader(convertEmployeeToEmployeeModel(employeeMapper.findAllByJobIdAndOrganizationId(4, organizationId)))
                .personnel(convertEmployeeToEmployeeModel(employeeMapper.findAllByJobIdAndOrganizationId(17, organizationId)))
                .finance(convertEmployeeToEmployeeModel(employeeMapper.findAllByJobIdAndOrganizationId(16, organizationId)))
                .build();
        return model;
    }

    /**
     * 获取审批人信息
     */
    public ApproverModel getApprover(Integer organizationId, Integer approvalTypeId) {
        ApprovalEmployee approvalEmployee = approvalEmployeeMapper.findByOrganizationIdAndApprovalType(organizationId, approvalTypeId);
        if (approvalEmployee == null) {
            approvalEmployee = new ApprovalEmployee();
        }
        List<Employee> manager = StringUtils.isEmpty(approvalEmployee.getManagerIds()) ? Collections.emptyList() : employeeMapper.findByIds(approvalEmployee.getManagerIds());
        List<Employee> leader = StringUtils.isEmpty(approvalEmployee.getLeaderIds()) ? Collections.emptyList() : employeeMapper.findByIds(approvalEmployee.getLeaderIds());
        List<Employee> personnel = StringUtils.isEmpty(approvalEmployee.getPersonnelIds()) ? Collections.emptyList() : employeeMapper.findByIds(approvalEmployee.getPersonnelIds());
        List<Employee> finance = StringUtils.isEmpty(approvalEmployee.getFinanceIds()) ? Collections.emptyList() : employeeMapper.findByIds(approvalEmployee.getFinanceIds());
        return ApproverModel.builder()
                .manager(convertEmployeeToEmployeeModel(manager))
                .leader(convertEmployeeToEmployeeModel(leader))
                .personnel(convertEmployeeToEmployeeModel(personnel))
                .finance(convertEmployeeToEmployeeModel(finance))
                .build();
    }

    /**
     * 获取抄送人信息
     */
    public List<EmployeeModel> getCc(Integer organizationId) {
        List<Employee> employees = employeeMapper.findByOrganizationId(organizationId);
        return convertEmployeeToEmployeeModel(employees);
    }

    /**
     * 获取多个员工信息
     */
    public List<EmployeeModel> getByIds(String ids) {
        List<Employee> employees = StringUtils.isEmpty(ids) ? Collections.emptyList() : employeeMapper.findByIds(ids);
        return convertEmployeeToEmployeeModel(employees);
    }

    public Employee getById(Integer id) {
        return employeeMapper.findById(id);
    }

    private List<EmployeeModel> convertEmployeeToEmployeeModel(List<Employee> employees) {
        if (employees == null) {
            return Collections.emptyList();
        }
        return employees.stream().map(employee -> {
            EmployeeModel employeeModel = EmployeeModel.builder()
                    .id(employee.getId())
                    .employeeName(employee.getEmployeeName())
                    .build();
            return employeeModel;
        }).collect(Collectors.toList());
    }

    public List<EmployeeModel> findByOrganizationId(Integer employeeId) {
        Employee e = employeeMapper.findById(employeeId);
        List<Employee> employeeList = employeeMapper.findByOrganizationId(e.getOrganizationId());
        List<EmployeeModel> employeeModelList = employeeList.stream().map(employee -> {
            EmployeeModel employeeModel = EmployeeModel.builder()
                    .id(employee.getId())
                    .employeeName(employee.getEmployeeName())
                    .organizationId(employee.getOrganizationId())
                    .build();
            return employeeModel;
        }).collect(Collectors.toList());
        return employeeModelList;
    }

    /**
     * 查询可以转正的员工
     */
    public List<Employee> getCanTurnPositive() {
        String ids = CommonUtil.convertListToString(employeeInformationMapper.findCanTurnPositive());
        return StringUtils.isEmpty(ids) ? Collections.emptyList() : employeeMapper.findByIds(ids);
    }

    /**
     * 查询可以合同续签的员工
     */
    public List<Employee> getContractRenew() {
        String ids = CommonUtil.convertListToString(employeeInformationMapper.findContractRenew());
        return StringUtils.isEmpty(ids) ? Collections.emptyList() : employeeMapper.findByIds(ids);
    }

    /**
     * 查询指定部门的部门经理
     */
    public List<Employee> getManagers(Integer organizationId) {
        return employeeMapper.findAllByJobIdAndOrganizationId(24, organizationId);
    }

    /**
     * 查询指定部门的人事
     */
    public List<Employee> getPersonnel(Integer organizationId) {
        return employeeMapper.findAllByJobIdAndOrganizationId(17, organizationId);
    }

}
