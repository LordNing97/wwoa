package com.xy.wwoa.employee.mapper;

import com.xy.wwoa.employee.model.Organization;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author leisurexi
 * @Description
 * @Date 2019/8/27
 * @Time 9:30
 */
@Mapper
public interface OrganizationMapper {

    //查询全部状态为正常的
    List<Organization> findAll();

    //根据id获取职位
    Organization findById(Integer id);

}
