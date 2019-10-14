package com.xy.wwoa.employee.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@ToString
public class Province {

    private Integer id;
    private String provinceName;
    private Integer type;
    private Integer specialType;
    private Integer isVacation;
    private Integer isDel;
    private LocalDateTime createTime;

}
