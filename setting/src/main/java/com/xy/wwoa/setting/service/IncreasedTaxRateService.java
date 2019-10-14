package com.xy.wwoa.setting.service;

import com.xy.wwoa.setting.api.IncreasedTaxRateList;
import com.xy.wwoa.setting.mapper.IncreasedTaxRateMapper;
import com.xy.wwoa.setting.model.IncreasedTaxRate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author 陈璇
 * @Description IncreasedTaxRateService
 * @date 2019/8/29 14:57
 */
@Service
public class IncreasedTaxRateService {

    @Resource
    private IncreasedTaxRateMapper increasedTaxRateMapper;

    /**
     * 保存增票税率
     */
    public boolean save(IncreasedTaxRate increasedTaxRate){
        return increasedTaxRateMapper.save(increasedTaxRate) > 0;
    }

    /**
     * 编辑增票税率
     */
    public boolean modify(IncreasedTaxRate increasedTaxRate){
        return increasedTaxRateMapper.modify(increasedTaxRate) > 0;
    }

    /**
     * 删除增票税率
     */
    public boolean delete(Integer id){
        return increasedTaxRateMapper.delete(id) > 0;
    }

    /**
     * 分页获取增票税率
     */
    public IncreasedTaxRateList listIncreasedTaxRate(String taxRate, Integer status, Integer page, Integer size){
        List<IncreasedTaxRate> increasedTaxRateList = increasedTaxRateMapper.listIncreasedTaxRate(taxRate, status , (page - 1) * size, page * size);
        return IncreasedTaxRateList.builder()
                .list(increasedTaxRateList)
                .page(page)
                .total(increasedTaxRateMapper.countIncreasedTaxRate(taxRate, status))
                .build();
    }

    /**
     * 根据ID获取增票税率
     */
    public IncreasedTaxRate findById(Integer id){
        return increasedTaxRateMapper.findById(id);
    }

}
