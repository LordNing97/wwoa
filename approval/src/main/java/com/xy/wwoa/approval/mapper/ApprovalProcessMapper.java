package com.xy.wwoa.approval.mapper;

import com.xy.wwoa.approval.model.ApprovalProcess;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: leisurexi
 * Date: 2019-08-27
 * Time: 22:57
 */
@Mapper
public interface ApprovalProcessMapper {

    int save(List<ApprovalProcess> list);

    int modifyStatus(@Param("id") int id, @Param("status") int status, @Param("approvalOpinion") String approvalOpinion, @Param("approvalTime") LocalDateTime approvalTime);

    int modifyNextProcess(@Param("id") int id, @Param("approvalNumber") String approvalNumber);

    //把流程改为不是最新状态
    int modifyNotLatest(int id);

    int modifyApproverId(@Param("id") int id, @Param("approverId") int approverId);

    //查询待处理
    List<ApprovalProcess> findPendingApproval(@Param("employeeId") Integer employeeId, @Param("approvalTypeId") Integer approvalTypeId);

    //查询已处理
    List<ApprovalProcess> processed(@Param("employeeId") Integer employeeId, @Param("approvalTypeId") Integer approvalTypeId, @Param("status") Integer status);

    List<ApprovalProcess> findByApprovalNumber(String approvalNumber);

    //根据审批编号查询最新的流程
    ApprovalProcess findLatest(String approvalNumber);

    List<ApprovalProcess> findByEmployeeId(@Param("employeeId") Integer employeeId, @Param("approvalTypeId") Integer approvalTypeId, @Param("status") Integer status);

    //根据审批编号查询已处理流程
    List<ApprovalProcess> findByApprovalNumberProcessed(String approvalNumber);

}
