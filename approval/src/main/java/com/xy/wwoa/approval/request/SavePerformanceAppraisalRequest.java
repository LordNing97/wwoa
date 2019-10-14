package com.xy.wwoa.approval.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Author 陈璇
 * @Description SavePerformanceAppraisalRequest
 * @date 2019/8/31 12:06
 */
@Data
@ToString
@ApiModel(value = "保存绩效自评审核参数对象")
public class SavePerformanceAppraisalRequest {

    @ApiModelProperty(name = "lastWorkTask", value = "上月工作任务", required = true, dataType = "string")
    @NotBlank(message = "请输入上月工作任务")
    @Length(min = 1, max = 200, message = "上月工作任务不能超过200个字符")
    private String lastWorkTask;
    @ApiModelProperty(name = "realityWorkTask", value = "实际工作任务", required = true, dataType = "string")
    @NotBlank(message = "请输入实际工作任务")
    @Length(min = 1, max = 200, message = "实际工作任务不能超过200个字符")
    private String realityWorkTask;
    @ApiModelProperty(name = "taskCompleteRate", value = "任务达成率", required = true, dataType = "string")
    @NotNull(message = "请输入任务达成率")
    private Integer taskCompleteRate;
    @ApiModelProperty(name = "lastWorkAppraisal", value = "上月工作自评", required = true, dataType = "string")
    @NotBlank(message = "请输入上月工作自评")
    @Length(min = 1, max = 200, message = "上月工作自评不能超过200个字符")
    private String lastWorkAppraisal;
    @ApiModelProperty(name = "workTask", value = "本月工作任务", required = true, dataType = "string")
    @NotBlank(message = "请输入本月工作任务")
    @Length(min = 1, max = 200, message = "本月工作任务不能超过200个字符")
    private String workTask;
    @ApiModelProperty(name = "workPlan", value = "本月工作计划", required = true, dataType = "string")
    @NotBlank(message = "请输入本月工作计划")
    @Length(min = 1, max = 200, message = "本月工作计划不能超过200个字符")
    private String workPlan;
    @ApiModelProperty(name = "approverIds", value = "审批人", required = true, dataType = "string")
    @NotBlank(message = "请选择审批人")
    private String approverIds;
    @ApiModelProperty(name = "ccIds", value = "抄送人", dataType = "string")
    private String ccIds;

}
