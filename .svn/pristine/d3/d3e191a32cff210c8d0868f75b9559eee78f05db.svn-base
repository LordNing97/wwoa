package com.xy.wwoa.common.api;

import lombok.Getter;

@Getter
public class Result<T> {

    private String msg;
    private int code;
    private T data;

    public Result(ResultBuilder<T> builder) {
        this.msg = builder.msg;
        this.code = builder.code;
        this.data = builder.data;
    }

    public static <T> ResultBuilder<T> builder() {
        return new ResultBuilder<>(ResultCode.SUCCESS);
    }

    public static <T> ResultBuilder<T> builder(ResultCode resultCode) {
        return new ResultBuilder<>(resultCode);
    }

    public static class ResultBuilder<T> {
        private int code;
        private String msg;
        private T data;

        public ResultBuilder(ResultCode resultCode) {
            this.msg = resultCode.msg;
            this.code = resultCode.code;
        }

        public ResultBuilder<T> code(int code) {
            this.code = code;
            return this;
        }

        public ResultBuilder<T>  msg(String msg) {
            this.msg = msg;
            return this;
        }

        public ResultBuilder<T>  data(T data) {
            this.data = data;
            return this;
        }

        public Result<T> build() {
            return new Result<>(this);
        }
    }

}
