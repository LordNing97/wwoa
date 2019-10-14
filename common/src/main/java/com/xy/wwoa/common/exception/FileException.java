package com.xy.wwoa.common.exception;

import com.xy.wwoa.common.api.ResultCode;

/**
 * @Author leisurexi
 * @Description
 * @Date 2019/8/31
 * @Time 16:27
 */
public class FileException extends ServiceException {

    public FileException(String message) {
        super(message);
    }

    public FileException(ResultCode resultCode) {
        super(resultCode);
    }
}
