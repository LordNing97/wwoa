package com.xy.wwoa.employee.service;

import com.xy.wwoa.employee.api.ApprovalEmployeeList;
import com.xy.wwoa.employee.api.ApprovalEmployeeModel;
import com.xy.wwoa.employee.model.ApprovalEmployee;
import com.xy.wwoa.employee.mapper.ApprovalEmployeeMapper;
import com.xy.wwoa.employee.mapper.EmployeeMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author leisurexi
 * @Description
 * @Date 2019/8/27
 * @Time 14:59
 */
@Service
public class ApprovalEmployeeService {

    @Resource
    private ApprovalEmployeeMapper approvalEmployeeMapper;

    @Resource
    private EmployeeMapper employeeMapper;

    /**
     * 根据部门id获取部门审批人员信息
     */
    public ApprovalEmployeeList listApprovalEmployee(Integer organizationId, Integer page, Integer size) {
        List<ApprovalEmployee> list = approvalEmployeeMapper.findByOrganizationId(organizationId, (page - 1) * size, page * size);
        List<ApprovalEmployeeModel> approvalEmployeeModels = new ArrayList<>(list.size());
        list.forEach(approvalEmployee -> {
            ApprovalEmployeeModel employeeModel = ApprovalEmployeeModel.builder()
                    .id(approvalEmployee.getId())
                    .organizationName(approvalEmployee.getOrganizationName())
                    .approvalTypeName(approvalEmployee.getApprovalTypeName())
                    .managerName(StringUtils.isEmpty(approvalEmployee.getManagerIds()) ? "无" : groupConcatNames(employeeMapper.findNameByIds(approvalEmployee.getManagerIds())))
                    .leaderNames(StringUtils.isEmpty(approvalEmployee.getLeaderIds()) ? "无" : groupConcatNames(employeeMapper.findNameByIds(approvalEmployee.getLeaderIds())))
                    .personnelNames(StringUtils.isEmpty(approvalEmployee.getPersonnelIds()) ? "无" : groupConcatNames(employeeMapper.findNameByIds(approvalEmployee.getPersonnelIds())))
                    .financeNames(StringUtils.isEmpty(approvalEmployee.getFinanceIds()) ? "无" : groupConcatNames(employeeMapper.findNameByIds(approvalEmployee.getFinanceIds())))
                    .build();
            approvalEmployeeModels.add(employeeModel);
        });
        ApprovalEmployeeList result = ApprovalEmployeeList.builder()
                .list(approvalEmployeeModels)
                .total(approvalEmployeeMapper.countByOrganizationId(organizationId))
                .page(page)
                .build();
        return result;
    }

    /**
     * 添加部门审批人员信息
     */
    public boolean save(ApprovalEmployee approvalEmployee) {
        return approvalEmployeeMapper.save(approvalEmployee) > 0;
    }

    /**
     * 删除部门审批人员信息
     */
    public boolean remove(Integer id) {
        return approvalEmployeeMapper.remove(id) > 0;
    }

    /**
     * 修改部门审批人员信息
     */
    public boolean modify(ApprovalEmployee approvalEmployee) {
        return approvalEmployeeMapper.modify(approvalEmployee) > 0;
    }

    private String groupConcatNames(List<String> employeeNameList) {
        if (employeeNameList.isEmpty()) {
            return "无";
        }
        String employeeNames = "";
        for (String name : employeeNameList) {
            employeeNames += name + ",";
        }
        return employeeNames.substring(0, employeeNames.length() - 1);
    }

}
