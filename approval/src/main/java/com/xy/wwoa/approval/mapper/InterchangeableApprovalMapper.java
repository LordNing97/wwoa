package com.xy.wwoa.approval.mapper;

import com.xy.wwoa.approval.model.InterchangeableApproval;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author leisurexi
 * @Description
 * @Date 2019/8/31
 * @Time 15:22
 */
@Mapper
public interface InterchangeableApprovalMapper {

    int save(InterchangeableApproval interchangeableApproval);

    InterchangeableApproval findByApprovalNumber(String approvalNumber);

    /**
     * 分页获取通用审批信息
     */
    long countInterchangeableApproval(@Param("organizationId") Integer organizationId, @Param("employeeName") String employeeName,@Param("applyContent") String applyContent);
    List<InterchangeableApproval> listInterchangeableApproval(@Param("organizationId") Integer organizationId, @Param("employeeName") String employeeName,@Param("applyContent") String applyContent,
                                                              @Param("page") Integer page,@Param("size") Integer size);

}
