package com.xy.wwoa.approval.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * @Author leisurexi
 * @Description
 * @Date 2019/9/2
 * @Time 10:21
 */
@Data
@ToString
@ApiModel(value = "后台 人事管理-入职审批列表参数对象")
public class ListEntryApprovalRequest {

    @ApiModelProperty(name = "organizationId", value = "部门id", dataType = "int")
    private Integer organizationId;
    @ApiModelProperty(name = "jobId", value = "岗位id", dataType = "int")
    private Integer jobId;
    @ApiModelProperty(name = "name", value = "姓名", dataType = "date")
    private String name;
    @ApiModelProperty(name = "telephone", value = "联系电话", dataType = "double")
    private String telephone;
    @ApiModelProperty(name = "status", value = "状态", dataType = "int")
    private Integer status;
    @ApiModelProperty(name = "page", value = "当前页", dataType = "int")
    private Integer page;
    @ApiModelProperty(name = "size", value = "每页显示数量", dataType = "int")
    private Integer size;

}
