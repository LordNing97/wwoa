package com.xy.wwoa.approval.mapper;

import com.xy.wwoa.approval.model.ApprovalType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * @Author leisurexi
 * @Description
 * @Date 2019/8/27
 * @Time 14:48
 */
@Mapper
public interface ApprovalTypeMapper {

    //查询全部审批类型
    List<ApprovalType> findAll();

    ApprovalType findById(int id);

}
