package com.xy.wwoa.employee.service;

import com.xy.wwoa.employee.mapper.ProvinceMapper;
import com.xy.wwoa.employee.model.Province;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author leisurexi
 * @Description
 * @Date 2019/8/30
 * @Time 11:43
 */
@Service
public class ProvinceService {

    @Resource
    private ProvinceMapper provinceMapper;

    /**
     * 获取全部岗位信息
     */
    public List<Province> listProvince() {
        return provinceMapper.findAll();
    }

}
