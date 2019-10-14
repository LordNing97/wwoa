package com.xy.wwoa.setting.mapper;

import com.xy.wwoa.setting.model.IncreasedTaxRate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author 陈璇
 * @Description IncreasedTaxRateMapper
 * @date 2019/8/29 14:44
 */
@Mapper
public interface IncreasedTaxRateMapper {

    /**
     * 保存增票税率
     */
    int save(IncreasedTaxRate increasedTaxRate);

    /**
     * 编辑增票税率
     */
    int modify(IncreasedTaxRate increasedTaxRate);

    /**
     * 删除增票税率
     */
    int delete(Integer id);

    /**
     * 分页获取增票税率
     */
    long countIncreasedTaxRate(@Param("taxRate") String taxRate, @Param("status") Integer status);
    List<IncreasedTaxRate> listIncreasedTaxRate(@Param("taxRate") String taxRate, @Param("status") Integer status,
                                                @Param("page") Integer page, @Param("size") Integer size);

    /**
     * 根据ID获取增票税率
     */
    IncreasedTaxRate findById(Integer id);

}
