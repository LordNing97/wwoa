package com.xy.wwoa.setting.service;

import com.xy.wwoa.setting.api.ContractTypeList;
import com.xy.wwoa.setting.mapper.ContractTypeMapper;
import com.xy.wwoa.setting.model.ContractType;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author leisurexi
 * @Description
 * @Date 2019/8/28
 * @Time 9:36
 */
@Service
public class ContractTypeService {

    @Resource
    private ContractTypeMapper contractTypeMapper;

    /**
     * 保存合同类型
     */
    public boolean save(ContractType contractType) {
        return contractTypeMapper.save(contractType) > 0;
    }

    /**
     * 删除合同类型
     */
    public boolean remove(Integer id) {
        return contractTypeMapper.remove(id) > 0;
    }

    /**
     * 编辑合同类型
     */
    public boolean modify(ContractType contractType) {
        return contractTypeMapper.modify(contractType) > 0;
    }

    /**
     * 查询合同类型
     */
    public ContractTypeList listContractType(String name, Integer status, Integer page, Integer size) {
        List<ContractType> contractTypeList = contractTypeMapper.listContractType(name, status, (page - 1) * size, page * size);
        return ContractTypeList.builder()
                .list(contractTypeList)
                .total(contractTypeMapper.countContractType(name, status))
                .page(page)
                .build();
    }

    /**
     * 获取所有启用的合同类型
     */
    public List<ContractType> getAll() {
        return contractTypeMapper.findAll();
    }


}
