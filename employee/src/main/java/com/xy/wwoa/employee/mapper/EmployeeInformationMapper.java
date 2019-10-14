package com.xy.wwoa.employee.mapper;

import com.xy.wwoa.employee.model.EmployeeInformation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author leisurexi
 * @Description
 * @Date 2019/8/30
 * @Time 16:16
 */
@Mapper
public interface EmployeeInformationMapper {

    int save(EmployeeInformation employeeInformation);

    //修改新员工相关信息
    int modifyNewEmployeeEntry(EmployeeInformation employeeInformation);

    //修改员工转正信息
    int updateEmployeeBecomeWorker(EmployeeInformation employeeInformation);

    //修改合同续签相关信息
    int modifyContractRenew(@Param("employeeId") Integer employeeId, @Param("currentSalary") BigDecimal currentSalary, @Param("maturityTime") LocalDateTime maturityTime);

    //修改员工在职状态
    void modifyEmployeeStatus(@Param("employeeId") Integer employeeId, @Param("employeeStatus") Integer employeeStatus);

    int modifyStatus(@Param("id") Integer id, @Param("status") Integer status);

    EmployeeInformation findByTelephone(String telephone);

    EmployeeInformation findById(Integer id);

    EmployeeInformation findByEmployeeId(Integer employeeId);

    //查询可以转正的员工id
    List<String> findCanTurnPositive();

    //查询可以合同续签的员工id
    List<String> findContractRenew();

}
