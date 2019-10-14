package com.xy.wwoa.approval.mapper;

import com.xy.wwoa.approval.model.EntryApproval;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author leisurexi
 * @Description
 * @Date 2019/8/28
 * @Time 11:05
 */
@Mapper
public interface EntryApprovalMapper {

    int save(EntryApproval entryApproval);

    int modifyStatus(@Param("approvalNumber") String approvalNumber, @Param("status") int status);

    EntryApproval findByApprovalNumber(@Param("approvalNumber") String approvalNumber,@Param("approvalTypeId") Integer approvalTypeId);

    long countEntryApproval(@Param("organizationId") Integer organizationId, @Param("jobId") Integer jobId, @Param("employeeName") String employeeName,
                            @Param("telephone") String telephone, @Param("status") Integer status);

    List<EntryApproval> listEntryApproval(@Param("organizationId") Integer organizationId, @Param("jobId") Integer jobId, @Param("employeeName") String employeeName,
                                          @Param("telephone") String telephone, @Param("status") Integer status, @Param("page") Integer page, @Param("size") Integer size);
}
