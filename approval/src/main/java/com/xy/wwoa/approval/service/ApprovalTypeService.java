package com.xy.wwoa.approval.service;


import com.xy.wwoa.approval.mapper.ApprovalTypeMapper;
import com.xy.wwoa.approval.model.ApprovalType;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author leisurexi
 * @Description
 * @Date 2019/8/27
 * @Time 14:50
 */
@Service
public class ApprovalTypeService {

    @Resource
    private ApprovalTypeMapper approvalTypeMapper;

    /**
     * 获取全部审批类型信息
     */
    public List<ApprovalType> listApprovalType() {
        return approvalTypeMapper.findAll();
    }

}
