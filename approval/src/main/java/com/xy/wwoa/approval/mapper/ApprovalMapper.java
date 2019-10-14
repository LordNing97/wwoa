package com.xy.wwoa.approval.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author leisurexi
 * @Description
 * @Date 2019/8/31
 * @Time 13:55
 */
@Mapper
public interface ApprovalMapper {

    int modifyStatus(@Param("approvalNumber") String approvalNumber, @Param("status") int status, @Param("tableName") String tableName);

    String findCcIds(@Param("approvalNumber") String approvalNumber, @Param("tableName") String tableName);

}
