package com.xy.wwoa.employee.mapper;

import com.xy.wwoa.employee.model.ApprovalEmployee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author leisurexi
 * @Description
 * @Date 2019/8/27
 * @Time 14:57
 */
@Mapper
public interface ApprovalEmployeeMapper {

    int save(ApprovalEmployee approvalEmployee);

    int remove(int id);

    int modify(ApprovalEmployee approvalEmployee);

    //根据部门id获取部门审批人员信息
    long countByOrganizationId(int organizationId);
    List<ApprovalEmployee> findByOrganizationId(@Param("organizationId") int organizationId, @Param("page") int page, @Param("size") int size);

    //根据部门id和审批类型获取部门审批人员信息
    ApprovalEmployee findByOrganizationIdAndApprovalType(@Param("organizationId") int organizationId, @Param("approvalTypeId") int approvalTypeId);

}
