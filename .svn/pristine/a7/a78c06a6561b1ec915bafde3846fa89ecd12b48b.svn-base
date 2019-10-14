package com.xy.wwoa.common.api;

import lombok.Getter;
import java.util.List;

/**
 * @Author leisurexi
 * @Description
 * @Date 2019/8/27
 * @Time 18:35
 */
@Getter
public class PageResult<T> {

    private String msg;
    private int code;
    private long total; //数据总数
    private int page;   //当前页码
    private List<T> data;

    public PageResult(PageResultBuilder<T> builder) {
        this.msg = builder.msg;
        this.code = builder.code;
        this.total = builder.total;
        this.page = builder.page;
        this.data = builder.data;
    }

    public static <T> PageResultBuilder<T> builder() {
        return new PageResultBuilder<>(ResultCode.SUCCESS);
    }

    public static <T> PageResultBuilder<T> builder(ResultCode resultCode) {
        return new PageResultBuilder<>(resultCode);
    }

    public static class PageResultBuilder<T> {
        private int code;
        private String msg;
        private long total;
        private int page;
        private List<T> data;

        public PageResultBuilder(ResultCode resultCode) {
            this.msg = resultCode.msg;
            this.code = resultCode.code;
        }

        public PageResultBuilder<T> code(int code) {
            this.code = code;
            return this;
        }

        public PageResultBuilder<T> msg(String msg) {
            this.msg = msg;
            return this;
        }

        public PageResultBuilder<T> data(List<T> data) {
            this.data = data;
            return this;
        }

        public PageResultBuilder<T> total(long total) {
            this.total = total;
            return this;
        }

        public PageResultBuilder<T> page(int page) {
            this.page = page;
            return this;
        }

        public PageResult<T> build() {
            return new PageResult<>(this);
        }
    }

}
