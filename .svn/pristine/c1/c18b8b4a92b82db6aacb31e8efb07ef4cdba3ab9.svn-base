package com.xy.wwoa.employee.service;

import com.xy.wwoa.employee.model.Organization;
import com.xy.wwoa.employee.mapper.OrganizationMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author leisurexi
 * @Description
 * @Date 2019/8/27
 * @Time 9:34
 */
@Service
public class OrganizationService {

    @Resource
    private OrganizationMapper organizationMapper;

    /**
     * 获取所有部门
     */
    public List<Organization> listOrganization() {
        return organizationMapper.findAll();
    }

}
