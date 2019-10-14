package com.xy.wwoa.approval.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * @Author 陈璇
 * @Description ListLeaveApprovalRequest
 * @date 2019/9/2 14:48
 */
@Data
@ToString
@ApiModel(value = "后台 人事管理-离职审批列表参数对象")
public class ListLeaveApprovalRequest {

    @ApiModelProperty(name = "organizationId", value = "部门id", dataType = "int")
    private Integer organizationId;
    @ApiModelProperty(name = "jobId", value = "岗位id", dataType = "int")
    private Integer jobId;
    @ApiModelProperty(name = "name", value = "姓名", dataType = "date")
    private String employeeName;
    @ApiModelProperty(name = "idcard", value = "身份证号", dataType = "string")
    private String idcard;
    @ApiModelProperty(name = "status", value = "状态", dataType = "int")
    private Integer status;
    @ApiModelProperty(name = "page", value = "当前页", dataType = "int")
    private Integer page;
    @ApiModelProperty(name = "size", value = "每页显示数量", dataType = "int")
    private Integer size;

}
