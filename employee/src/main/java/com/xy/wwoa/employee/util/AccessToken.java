package com.xy.wwoa.employee.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @Author leisurexi
 * @Description
 * @Date 2019/9/4
 * @Time 17:54
 */
@Data
@ToString
@AllArgsConstructor
public class AccessToken {

    private String token;
    private LocalDateTime expireTime;

}
