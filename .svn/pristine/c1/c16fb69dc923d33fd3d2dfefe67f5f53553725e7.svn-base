package com.xy.wwoa.approval.mapper;

import com.xy.wwoa.approval.model.ContractApproval;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author leisurexi
 * @Description
 * @Date 2019/9/5
 * @Time 13:55
 */
@Mapper
public interface ContractApprovalMapper {

    int save(ContractApproval contractApproval);

    ContractApproval findByApprovalNumber(String approvalNumber);

    long countContractApproval(@Param("organizationId") Integer organizationId, @Param("contractNumber") String contractNumber, @Param("contractTypeId") Integer contractTypeId,
                               @Param("signingTime") LocalDateTime signingTime, @Param("ourSideCompanyName") String ourSideCompanyName, @Param("otherSideCompanyName") String otherSideCompanyName);

    List<ContractApproval> listContractApproval(@Param("organizationId") Integer organizationId, @Param("contractNumber") String contractNumber, @Param("contractTypeId") Integer contractTypeId,
                                                @Param("signingTime") LocalDateTime signingTime, @Param("ourSideCompanyName") String ourSideCompanyName, @Param("otherSideCompanyName") String otherSideCompanyName,
                                                @Param("page") Integer page, @Param("size") Integer size);

}
