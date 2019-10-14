package com.xy.wwoa.approval.exception;

import com.xy.wwoa.common.api.ResultCode;
import com.xy.wwoa.common.exception.ServiceException;

/**
 * @Author leisurexi
 * @Description
 * @Date 2019/8/31
 * @Time 10:25
 */
public class ApprovalException extends ServiceException {

    public ApprovalException(String message) {
        super(message);
    }

    public ApprovalException(ResultCode resultCode) {
        super(resultCode);
    }

    public ApprovalException(ResultCode resultCode, String msg) {
        super(resultCode, msg);
    }

}
