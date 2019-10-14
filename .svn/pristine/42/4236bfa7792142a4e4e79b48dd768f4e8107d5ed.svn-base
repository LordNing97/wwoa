package com.xy.wwoa.approval.mapper;

import com.xy.wwoa.approval.model.RenewApproval;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: leisurexi
 * Date: 2019-08-27
 * Time: 21:51
 */
@Mapper
public interface RenewApprovalMapper {

    int save(RenewApproval renewApproval);

    int modify(RenewApproval renewApproval);

    RenewApproval findByApprovalNumber(String approvalNumber);

    long countContractApproval(@Param("organizationId") Integer organizationId, @Param("jobId") Integer jobId, @Param("employeeName") String employeeName,
                            @Param("telephone") String telephone, @Param("status") Integer status);

    List<RenewApproval> listContractApproval(@Param("organizationId") Integer organizationId, @Param("jobId") Integer jobId, @Param("employeeName") String employeeName,
                                             @Param("telephone") String telephone, @Param("status") Integer status, @Param("page") Integer page, @Param("size") Integer size);

}
