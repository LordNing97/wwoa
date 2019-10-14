package com.xy.wwoa.setting.mapper;

import com.xy.wwoa.setting.model.ReimbursementCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author 陈璇
 * @Description ReimbursementCategoryMapper
 * @date 2019/8/28 12:01
 */
@Mapper
public interface ReimbursementCategoryMapper {

    /**
     * 添加报销类别
     */
    int save(ReimbursementCategory reimbursementCategory);

    /**
     * 获取所有报销类别
     */
    long reimbursementCategorySize(@Param("category") String category,@Param("status") Integer status);
    List<ReimbursementCategory> listReimbursementCategory(@Param("category") String category,@Param("status") Integer status,
                                                          @Param("page") Integer page,@Param("size") Integer size);

    /**
     * 编辑报销类别
     */
    int modify(ReimbursementCategory reimbursementCategory);

    /**
     * 删除报销类别
     */
    int remove(Integer id);

    /**
     * 根据ID获取单个报销类别
     */
    ReimbursementCategory findById(Integer id);

    /**
     * 根据名字获取单个报销类别
     */
    ReimbursementCategory findByName(String name);

}
