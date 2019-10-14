package com.xy.wwoa.employee.util;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * @Author leisurexi
 * @Description
 * @Date 2019/9/4
 * @Time 16:11
 */
@Data
@ToString
@Builder
public class Articles {

    private String title;
    private String description;
    private String url;
    private String picurl;

}
