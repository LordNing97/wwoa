package com.xy.wwoa.common.api;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.servlet.http.HttpServletResponse;


@Getter
@AllArgsConstructor
public enum ResultCode {
    SUCCESS(HttpServletResponse.SC_OK, "Operation is Successful"),

    FAILURE(HttpServletResponse.SC_BAD_REQUEST, "Biz Exception"),

    UN_AUTHORIZED(HttpServletResponse.SC_UNAUTHORIZED, "Request Unauthorized"),

    NOT_FOUND(HttpServletResponse.SC_NOT_FOUND, "404 Not Found"),

    MSG_NOT_READABLE(HttpServletResponse.SC_BAD_REQUEST, "Message Can't be Read"),

    METHOD_NOT_SUPPORTED(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "Method Not Supported"),

    MEDIA_TYPE_NOT_SUPPORTED(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE, "Media Type Not Supported"),

    REQ_REJECT(HttpServletResponse.SC_FORBIDDEN, "Request Rejected"),

    INTERNAL_SERVER_ERROR(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Internal Server Error"),

    PARAM_MISS(HttpServletResponse.SC_BAD_REQUEST, "Missing Required Parameter"),

    PARAM_TYPE_ERROR(HttpServletResponse.SC_BAD_REQUEST, "Parameter Type Mismatch"),

    PARAM_BIND_ERROR(HttpServletResponse.SC_BAD_REQUEST, "Parameter Binding Error"),

    PARAM_VALID_ERROR(HttpServletResponse.SC_BAD_REQUEST, "Parameter Validation Error"),

    SAVE_ERROR(HttpServletResponse.SC_BAD_REQUEST, "保存失败"),

    DELETE_ERROR(HttpServletResponse.SC_BAD_REQUEST, "删除失败"),

    REMOVE_ERROR(HttpServletResponse.SC_BAD_REQUEST, "删除失败"),

    Login_ERROR(HttpServletResponse.SC_BAD_REQUEST, "登录失败"),

    LOGIN_EXPIRED(HttpServletResponse.SC_BAD_REQUEST, "登录已过期"),

    UN_REGISTER(HttpServletResponse.SC_BAD_REQUEST, "请先注册"),

    FILE_TYPE_ERROR(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "文件类型不支持"),

    FILE_SIZE_OUT(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "文件大小超过5M"),

    TELEPHONE_OR_PWD_ERROR(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "手机号或密码错误");

    final int code;

    final String msg;
}
