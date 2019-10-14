package com.xy.wwoa.setting.mapper;

import com.xy.wwoa.setting.model.Company;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author 陈璇
 * @Description CompanyMapper
 * @date 2019/8/30 9:07
 */
@Mapper
public interface CompanyMapper {

    /**
     * 保存公司
     */
    int save(Company company);

    /**
     * 编辑公司
     */
    int modify(Company company);

    /**
     * 删除公司
     */
    int delete(Integer id);

    /**
     * 分页获取公司
     */
    long countCompany(@Param("name") String name, @Param("address") String address);
    List<Company> listCompany(@Param("name") String name, @Param("address") String address,
                              @Param("page") Integer page, @Param("size") Integer size);

}
