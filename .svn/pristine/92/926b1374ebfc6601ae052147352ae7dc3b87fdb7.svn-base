package com.xy.wwoa.setting.mapper;

import com.xy.wwoa.setting.model.FixedcostsCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author 陈璇
 * @Description FixedcostsCategoryMapper
 * @date 2019/8/28 17:23
 */
@Mapper
public interface FixedcostsCategoryMapper {

    /**
     * 保存固定费用类别
     */
    int save(FixedcostsCategory fixedcostsCategory);

    /**
     * 编辑固定费用类别
     */
    int modify(FixedcostsCategory fixedcostsCategory);

    /**
     * 删除固定费用类别
     */
    int delete(Integer id);

    /**
     * 分页查询固定费用类别
     */
    long countFixedcostsCategory(@Param("category") String category,@Param("status") Integer status);
    List<FixedcostsCategory> listFixedcostsCategory(@Param("category") String category,@Param("status") Integer status,
                                                    @Param("page") Integer page,@Param("size") Integer size);

    /**
     * 根据ID获取固定费用类别
     */
    FixedcostsCategory selectById(Integer id);


}
