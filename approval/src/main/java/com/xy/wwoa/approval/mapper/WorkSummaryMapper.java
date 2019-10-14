package com.xy.wwoa.approval.mapper;

import com.xy.wwoa.approval.model.WorkSummary;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author 陈璇
 * @Description WorkSummaryMapper
 * @date 2019/8/31 16:57
 */
@Mapper
public interface WorkSummaryMapper {

    /**
     * 添加工作总结信息
     */
    int save(WorkSummary workSummary);

    /**
     * 根据审批编号获取工作总结信息
     */
    WorkSummary findByApprovalNumber(String approvalNumber);

    /**
     * 分页获取工作总结信息
     */
    long countWorkSummary(@Param("organizationId") Integer organizationId, @Param("employeeName") String employeeName,@Param("workContent") String workContent);
    List<WorkSummary> listWorkSummary(@Param("organizationId") Integer organizationId, @Param("employeeName") String employeeName,@Param("workContent") String workContent,
                                      @Param("page") Integer page,@Param("size") Integer size);

    /**
     * 根据ID获取工作总结信息
     */
    WorkSummary findById(Integer id);

}
