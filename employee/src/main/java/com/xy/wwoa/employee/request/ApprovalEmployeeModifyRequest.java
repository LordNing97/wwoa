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
 * @Time 18:20
 */
@Data
@ToString
@ApiModel(value = "编辑部门审批人员参数对象")
public class ApprovalEmployeeModifyRequest {

    @ApiModelProperty(name = "id", value = "部门审批人员id", required = true, dataType = "string")
    @NotNull
    private Integer id;
    @ApiModelProperty(name = "managerIds", value = "经理ids", dataType = "string")
    private String managerIds;
    @ApiModelProperty(name = "leaderIds", value = "领导ids", dataType = "string")
    private String leaderIds;
    @ApiModelProperty(name = "personnelIds", value = "人事ids", dataType = "string")
    private String personnelIds;
    @ApiModelProperty(name = "financeIds", value = "财务ids", dataType = "string")
    private String financeIds;

}
