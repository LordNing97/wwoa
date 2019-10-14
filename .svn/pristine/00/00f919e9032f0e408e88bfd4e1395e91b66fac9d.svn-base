package com.xy.wwoa.setting.service;

import com.xy.wwoa.setting.api.CompanyList;
import com.xy.wwoa.setting.mapper.CompanyMapper;
import com.xy.wwoa.setting.model.Company;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author 陈璇
 * @Description CompanyService
 * @date 2019/8/30 9:10
 */
@Service
public class CompanyService {

    @Resource
    private CompanyMapper companyMapper;

    /**
     * 保存公司
     */
    public boolean save(Company company){
        return companyMapper.save(company) > 0;
    }

    /**
     * 编辑公司
     */
    public boolean modify(Company company){
        return companyMapper.modify(company) > 0;
    }

    /**
     * 删除公司
     */
    public boolean delete(Integer id){
        return companyMapper.delete(id) > 0;
    }

    /**
     * 分页获取公司
     */
    public CompanyList listCompany(String name, String address, Integer page, Integer size){
        List<Company> companyList = companyMapper.listCompany(name, address , (page - 1) * size, page * size);
        return CompanyList.builder()
                .list(companyList)
                .total(companyMapper.countCompany(name, address))
                .page(page)
                .build();
    }

}
