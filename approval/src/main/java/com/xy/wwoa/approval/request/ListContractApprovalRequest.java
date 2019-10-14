package com.xy.wwoa.approval.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * @Author leisurexi
 * @Description
 * @Date 2019/9/5
 * @Time 17:17
 */
@Data
@ToString
@ApiModel(value = "后台 项目管理-合同审批")
public class ListContractApprovalRequest {

    @ApiModelProperty(name = "organizationId", value = "部门id")
    private Integer organizationId;
    @ApiModelProperty(name = "contractNumber", value = "合同编号")
    private String contractNumber;
    @ApiModelProperty(name = "contractTypeId", value = "合同类型")
    private Integer contractTypeId;
    @ApiModelProperty(name = "signingTime", value = "签约时间")
    private LocalDateTime signingTime;
    @ApiModelProperty(name = "ourSideCompanyName", value = "我方单位名称")
    private String ourSideCompanyName;
    @ApiModelProperty(name = "otherSideCompanyName", value = "对方单位名称")
    private String otherSideCompanyName;
    @ApiModelProperty(name = "page", value = "当前页")
    private Integer page;
    @ApiModelProperty(name = "size", value = "每页显示数量")
    private Integer size;

}
