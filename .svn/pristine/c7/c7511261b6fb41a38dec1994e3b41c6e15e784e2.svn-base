package com.xy.wwoa.setting.service;

import com.xy.wwoa.setting.api.ReimbursementCategoryList;
import com.xy.wwoa.setting.mapper.ReimbursementCategoryMapper;
import com.xy.wwoa.setting.model.ReimbursementCategory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author 陈璇
 * @Description ReimbursementCategoryService
 * @date 2019/8/28 12:06
 */
@Service
public class ReimbursementCategoryService {

    @Resource
    private ReimbursementCategoryMapper reimbursementCategoryMapper;

    /**
     * 保存报销类别
     */
    public boolean save(ReimbursementCategory reimbursementCategory){
        return reimbursementCategoryMapper.save(reimbursementCategory) > 0;
    }

    /**
     * 获取所有报销类别
     */
    public ReimbursementCategoryList listReimbursementCategory(String category,Integer status,Integer page,Integer size){
        List<ReimbursementCategory> reimbursementCategoryList = reimbursementCategoryMapper.listReimbursementCategory(category, status, (page - 1) * size,page * size);
        return ReimbursementCategoryList.builder()
                .list(reimbursementCategoryList)
                .total(reimbursementCategoryMapper.reimbursementCategorySize(category, status))
                .page(page)
                .build();
    }

    /**
     * 编辑报销类别
     */
    public boolean modify(ReimbursementCategory reimbursementCategory){
        return reimbursementCategoryMapper.modify(reimbursementCategory) > 0;
    }

    /**
     * 删除报销类别
     */
    public boolean remove(Integer id){
        return reimbursementCategoryMapper.remove(id) > 0;
    }

    /**
     * 根据ID获取单个报销类别
     */
    public ReimbursementCategory findById(Integer id){
        return reimbursementCategoryMapper.findById(id);
    }

}
