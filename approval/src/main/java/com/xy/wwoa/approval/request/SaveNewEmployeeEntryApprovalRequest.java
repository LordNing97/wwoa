package com.xy.wwoa.approval.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * @Author leisurexi
 * @Description
 * @Date 2019/8/30
 * @Time 18:25
 */
@Data
@ToString
@ApiModel(value = "保存新员工入职审批参数对象")
public class SaveNewEmployeeEntryApprovalRequest {

    @ApiModelProperty(name = "name", value = "姓名", required = true, dataType = "string")
    @NotBlank(message = "请输入姓名")
    private String name;
    @ApiModelProperty(name = "sex", value = "性别", required = true, dataType = "string")
    @NotBlank(message = "请选择性别")
    private String sex;
    @ApiModelProperty(name = "nation", value = "民族", required = true, dataType = "string")
    @NotBlank(message = "请输入民族")
    private String nation;
    @ApiModelProperty(name = "birthday", value = "出生日期", required = true, dataType = "datetime")
    @NotNull(message = "请选择出生日期")
    private LocalDateTime birthday;
    @ApiModelProperty(name = "idCard", value = "身份证号", required = true, dataType = "string")
    @NotBlank(message = "请输入身份证号")
    private String idCard;
    @ApiModelProperty(name = "registeredResidence", value = "户口所在地", required = true, dataType = "string")
    @NotBlank(message = "请输入户口所在地")
    private String registeredResidence;
    @ApiModelProperty(name = "politicalAppearance", value = "政治面貌", required = true, dataType = "string")
    @NotBlank(message = "请输入政治面貌")
    private String politicalAppearance;
    @ApiModelProperty(name = "maritalStatus", value = "婚姻状况", required = true, dataType = "string")
    @NotBlank(message = "请选择试婚姻状况")
    private String maritalStatus;
    @ApiModelProperty(name = "weixinNo", value = "微信号", required = true, dataType = "string")
    @NotBlank(message = "请输入微信号")
    private String weixinNo;
    @ApiModelProperty(name = "email", value = "邮箱", required = true, dataType = "string")
    @NotBlank(message = "请输入邮箱")
    private String email;
    @ApiModelProperty(name = "telephone", value = "电话", required = true, dataType = "string")
    @NotBlank(message = "请输入电话")
    private String telephone;
    @ApiModelProperty(name = "selfEvaluation", value = "自我评价", required = true, dataType = "string")
    @NotBlank(message = "请输入自我评价")
    private String selfEvaluation;
    @ApiModelProperty(name = "certificateAndSkills", value = "获得证书以及技能", required = true, dataType = "string")
    @NotBlank(message = "请选择获得证书以及技能")
    private String certificateAndSkills;
    @ApiModelProperty(name = "familyAddress", value = "家庭住址", required = true, dataType = "string")
    @NotBlank(message = "请输入家庭住址")
    private String familyAddress;
    @ApiModelProperty(name = "presentAddress", value = "现住址", required = true, dataType = "string")
    @NotBlank(message = "请输入现住址")
    private String presentAddress;
    @ApiModelProperty(name = "emergencyContactName", value = "紧急联系人姓名", required = true, dataType = "string")
    @NotBlank(message = "请输入紧急联系人姓名")
    private String emergencyContactName;
    @ApiModelProperty(name = "emergencyContactPhone", value = "紧急联系人电话", required = true, dataType = "string")
    @NotBlank(message = "请输入紧急联系人电话")
    private String emergencyContactPhone;
    @ApiModelProperty(name = "employeeId", value = "审批人", required = true, dataType = "string")
    @NotBlank(message = "请选择审批人")
    private String approverIds;
    @ApiModelProperty(name = "employeeId", value = "抄送人", dataType = "string")
    private String ccIds;
    @ApiModelProperty(name = "educationStatusJson", value = "教育状况json字符串", required = true, dataType = "string")
    @NotBlank(message = "请输入教育状况")
    private String educationStatusJson;
    @ApiModelProperty(name = "familyStatusJson", value = "家庭状况json字符串", required = true, dataType = "string")
    @NotBlank(message = "请输入家庭状况")
    private String familyStatusJson;
    @ApiModelProperty(name = "jobResumeJson", value = "工作履历json字符串", required = true, dataType = "string")
    @NotBlank(message = "请输入工作履历")
    private String jobResumeJson;
    @ApiModelProperty(name = "employeeId", value = "员工id", required = true, dataType = "string")
    @NotNull
    private Integer employeeId;

}
