package com.xy.wwoa.employee.config;

import com.xy.wwoa.employee.model.Employee;

/**
 * @Author leisurexi
 * @Description
 * @Date 2019/8/29
 * @Time 16:27
 */
public class EmployeeContext {

    private static ThreadLocal<Employee> employeeHolder = new ThreadLocal<>();

    public static Employee getEmployeeHolder() {
        return employeeHolder.get();
    }

    public static void setEmployeeHolder(Employee employeeModel) {
        EmployeeContext.employeeHolder.set(employeeModel);
    }
}
