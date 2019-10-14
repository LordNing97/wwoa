package com.xy.wwoa.employee.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * @Author leisurexi
 * @Description
 * @Date 2019/8/27
 * @Time 15:24
 */
@Data
@ToString
@ApiModel(value = "保存部门审批人员参数对象")
public class ApprovalEmployeeSaveRequest {

    @ApiModelProperty(name = "organizationId", value = "部门id", required = true, dataType = "string")
    @NotNull(message = "请选择部门")
    private Integer organizationId;
    @ApiModelProperty(name = "approvalTypeId", value = "审批类型id", required = true, dataType = "string")
    @NotNull(message = "请选择审批类型")
    private Integer approvalTypeId;
    @ApiModelProperty(name = "managerIds", value = "经理ids", dataType = "string")
    private String managerIds;
    @ApiModelProperty(name = "leaderIds", value = "领导ids", dataType = "string")
    private String leaderIds;
    @ApiModelProperty(name = "personnelIds", value = "人事ids", dataType = "string")
    private String personnelIds;
    @ApiModelProperty(name = "financeIds", value = "财务ids", dataType = "string")
    private String financeIds;

}
