package com.xy.wwoa.employee.exception;

import com.xy.wwoa.common.api.ResultCode;
import com.xy.wwoa.common.exception.ServiceException;

/**
 * @Author leisurexi
 * @Description
 * @Date 2019/8/31
 * @Time 10:25
 */
public class EmployeeException extends ServiceException {

    public EmployeeException(String message) {
        super(message);
    }

    public EmployeeException(ResultCode resultCode) {
        super(resultCode);
    }

    public EmployeeException(ResultCode resultCode, String msg) {
        super(resultCode, msg);
    }

}
