package com.xy.wwoa.employee.util;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;


/**
 * @Author leisurexi
 * @Description
 * @Date 2019/9/4
 * @Time 16:09
 */
@Data
@ToString
@Builder
public class PhotoMessage {

    private String touser;
    private String toparty;
    private Integer employeeId;
    private String employeeName;
    private Integer userId;
    private String approvalNumber;

}
