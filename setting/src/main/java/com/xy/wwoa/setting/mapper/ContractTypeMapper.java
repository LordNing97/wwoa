package com.xy.wwoa.setting.mapper;

import com.xy.wwoa.setting.model.ContractType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author leisurexi
 * @Description
 * @Date 2019/8/28
 * @Time 9:22
 */
@Mapper
public interface ContractTypeMapper {

    int save(ContractType contractType);

    int remove(Integer id);

    int modify(ContractType contractType);

    long countContractType(@Param("name") String name, @Param("status") Integer status);
    List<ContractType> listContractType(@Param("name") String name, @Param("status") Integer status,
                                        @Param("page") int page, @Param("size") int size);

    List<ContractType> findAll();

    ContractType findById(Integer id);

}
