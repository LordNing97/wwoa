package com.xy.wwoa.employee.model;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @Author 陈璇
 * @Description JobResume
 * @date 2019/8/30 17:26
 */
@Data
@ToString
public class JobResume {

    private Integer id;
    private String companyName;
    private String post;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String telephone;
    private String quitReason;
    private String witness;

}
