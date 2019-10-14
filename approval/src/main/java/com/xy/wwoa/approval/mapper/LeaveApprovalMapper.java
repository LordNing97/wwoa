package com.xy.wwoa.approval.mapper;

import com.xy.wwoa.approval.model.LeaveApproval;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author 陈璇
 * @Description LeaveApprovalMapper
 * @date 2019/8/31 9:31
 */
@Mapper
public interface LeaveApprovalMapper {

    /**
     * 添加员工离职审批信息
     */
    int save(LeaveApproval leaveApproval);

    /**
     * 修改离职审批状态
     */
    int modifyStatus(@Param("approvalNumber") String approvalNumber, @Param("status") int status);

    /**
     * 根据审批编号获取离职审批信息
     */
    LeaveApproval findByApprovalNumber(String approvalNumber);

    /**
     * 分页获取离职审批信息
     */
    long countLeaveApproval(@Param("organizationId") Integer organizationId, @Param("jobId") Integer jobId, @Param("employeeName") String employeeName,
                            @Param("idcard") String idcard, @Param("status") Integer status);
    List<LeaveApproval> listLeaveApproval(@Param("organizationId") Integer organizationId, @Param("jobId") Integer jobId, @Param("employeeName") String employeeName,
                                          @Param("idcard") String idcard, @Param("status") Integer status, @Param("page") Integer page, @Param("size") Integer size);

}
