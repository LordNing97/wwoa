package com.xy.wwoa.setting.service;

import com.xy.wwoa.common.api.Result;
import com.xy.wwoa.setting.api.FixedcostsCategoryList;
import com.xy.wwoa.setting.mapper.FixedcostsCategoryMapper;
import com.xy.wwoa.setting.model.FixedcostsCategory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author 陈璇
 * @Description FixedcostsCategoryService
 * @date 2019/8/29 8:52
 */
@Service
public class FixedcostsCategoryService {

    @Resource
    private FixedcostsCategoryMapper fixedcostsCategoryMapper;

    /**
     * 保存固定费用类别
     */
    public boolean save(FixedcostsCategory fixedcostsCategory){
        return fixedcostsCategoryMapper.save(fixedcostsCategory) > 0;
    }

    /**
     * 编辑固定费用类别
     */
    public boolean modify(FixedcostsCategory fixedcostsCategory){
        return fixedcostsCategoryMapper.modify(fixedcostsCategory) > 0;
    }

    /**
     * 删除固定费用类别
     */
    public boolean delete(Integer id){
        return fixedcostsCategoryMapper.delete(id) > 0;
    }

    /**
     * 分页查询固定费用类别
     */
    public FixedcostsCategoryList listFixedcostsCategory(String category,Integer status,Integer page,Integer size){
        List<FixedcostsCategory> fixedcostsCategoryList = fixedcostsCategoryMapper.listFixedcostsCategory(category, status, (page - 1) * size, page * size);
        return FixedcostsCategoryList.builder()
                .list(fixedcostsCategoryList)
                .total(fixedcostsCategoryMapper.countFixedcostsCategory(category, status))
                .page(page)
                .build();
    }

    /**
     * 根据ID获取固定费用类别
     */
    public FixedcostsCategory selectById(Integer id){
        return fixedcostsCategoryMapper.selectById(id);
    }

}
