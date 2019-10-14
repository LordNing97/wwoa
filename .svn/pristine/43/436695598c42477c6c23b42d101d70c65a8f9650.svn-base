package com.xy.wwoa.approval.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * @Author 陈璇
 * @Description SaveLeaveApprovalRequest
 * @date 2019/8/31 9:43
 */
@Data
@ToString
@ApiModel(value = "保存员工离职审批参数对象")
public class SaveLeaveApprovalRequest {

    @ApiModelProperty(name = "actualApplicantId", value = "实际申请人", required = true, dataType = "int")
    @NotNull(message = "请选择实际申请人")
    private Integer actualApplicantId;
    @ApiModelProperty(name = "leavingReason", value = "离职原因", required = true, dataType = "string")
    @NotBlank(message = "请输入离职原因")
    private String leavingReason;
    @ApiModelProperty(name = "leavingTime", value = "离职时间", required = true, dataType = "datetime")
    @NotNull(message = "请选择离职时间")
    private LocalDateTime leavingTime;
    @ApiModelProperty(name = "workHandover", value = "工作交接是否交接", required = true, dataType = "int")
    @NotNull(message = "请选择工作交接是否交接")
    private Integer workHandover;
    @ApiModelProperty(name = "workHandoverEmployee", value = "工作交接人", required = true, dataType = "int")
    @NotNull(message = "请选择工作交接人")
    private Integer workHandoverEmployee;
    @ApiModelProperty(name = "approverIds", value = "审批人", required = true, dataType = "string")
    @NotBlank(message = "请选择审批人")
    private String approverIds;
    @ApiModelProperty(name = "ccIds", value = "抄送人", dataType = "string")
    private String ccIds;

}
