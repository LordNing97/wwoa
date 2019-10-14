package com.xy.wwoa.employee.model;

import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @Author 陈璇
 * @Description EducationStatus
 * @date 2019/8/30 17:05
 */
@Data
@ToString
public class EducationStatus {

    private Integer id;
    private String schoolName;
    private String major;
    private String education;
    private Integer fullTime;
    private LocalDateTime enrollmentTime;
    private LocalDateTime graduationTime;

}
