package com.xy.wwoa.employee.mapper;

import com.xy.wwoa.employee.model.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author 陈璇
 * @Description Employee
 * @date 2019/8/27 14:42
 */
@Mapper
public interface EmployeeMapper {

    //根据部门和岗位获取员工信息
    List<Employee> findAllByJobIdAndOrganizationId(int jobId, int organizationId);

    //根据多个id查询name
    List<String> findNameByIds(@Param("ids") String ids);

    //根据多个id查询
    List<Employee> findByIds(@Param("ids") String ids);

    //根据部门id查询
    List<Employee> findByOrganizationId(int organizationId);

    Employee findByOpenId(String openId);

    Employee findById(Integer id);

    //根据部门获取所有人事
    String findAllPersonnelMatters(Integer organizationId);

    Employee login(@Param("telephone") String telephone, @Param("password") String password);

    //修改员工在职状态
    void modifyStatus(@Param("id") Integer id, @Param("status") Integer status);

    //修改员工转正信息
    void updateEmployeeBecomeWorker(@Param("id") Integer id, @Param("jobId") Integer jobId);

}
