package com.xy.wwoa.approval.mapper;

import com.xy.wwoa.approval.model.Cc;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: leisurexi
 * Date: 2019-08-30
 * Time: 22:55
 */
@Mapper
public interface CcMapper {

    int save(List<Cc> list);

    int modifyCcStatus(String[] ids);

    List<Cc> findByEmployeeId(@Param("employeeId") Integer employeeId, @Param("approvalTypeId") Integer approvalTypeId, @Param("status") Integer status);

}
