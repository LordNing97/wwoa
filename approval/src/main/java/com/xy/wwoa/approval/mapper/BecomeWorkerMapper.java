package com.xy.wwoa.approval.mapper;

import com.xy.wwoa.approval.model.BecomeWorker;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author 陈璇
 * @Description BecomeWorkerMapper
 * @date 2019/9/2 16:07
 */
@Mapper
public interface BecomeWorkerMapper {

    /**
     * 添加转正信息
     */
    int save(BecomeWorker becomeWorker);

    /**
     * 更新转正信息
     */
    int modify(BecomeWorker becomeWorker);

    /**
     * 根据审批编号获取转正信息
     */
    BecomeWorker findByApprovalNumber(String approvalNumber);

    /**
     * 分页获取转正信息
     */
    long countBecomeWorker(@Param("organizationId") Integer organizationId, @Param("jobId") Integer jobId, @Param("employeeName") String employeeName,
                           @Param("idcard") String idcard);
    List<BecomeWorker> listBecomeWorker(@Param("organizationId") Integer organizationId, @Param("jobId") Integer jobId, @Param("employeeName") String employeeName,
                                        @Param("idcard") String idcard, @Param("page") Integer page, @Param("size") Integer size);

    /**
     * 根据ID获取转正信息
     */
    BecomeWorker findById(Integer id);

}
