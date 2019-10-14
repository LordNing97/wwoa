package com.xy.wwoa.approval.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Author leisurexi
 * @Description
 * @Date 2019/8/28
 * @Time 11:20
 */
@Data
@ToString
@ApiModel(value = "保存入职审批参数对象")
public class SaveEntryApprovalRequest {

    @ApiModelProperty(name = "name", value = "姓名", required = true)
    @NotBlank(message = "请输入姓名")
    private String name;
    @ApiModelProperty(name = "organizationId", value = "部门id", required = true)
    @NotNull(message = "请选择部门")
    private Integer organizationId;
    @ApiModelProperty(name = "jobId", value = "岗位id", required = true)
    @NotNull(message = "请选择岗位")
    private Integer jobId;
    @ApiModelProperty(name = "takeOfficeCity", value = "职城市地点", required = true)
    @NotBlank(message = "请选择就职城市地点")
    private String takeOfficeCity;
    @ApiModelProperty(name = "entryTime", value = "入职日期", required = true)
    @NotNull(message = "请选择入职日期")
    private LocalDateTime entryTime;
    @ApiModelProperty(name = "telephone", value = "联系电话", required = true)
    @NotBlank(message = "请输入联系电话")
    private String telephone;
    @ApiModelProperty(name = "probationTime", value = "试用期时长", required = true)
    @NotNull(message = "请选择试用期时长（单位: 月）")
    private Integer probationTime;
    @ApiModelProperty(name = "probationSalary", value = "用期工薪", required = true)
    @NotNull(message = "请输入试用期工薪")
    private BigDecimal probationSalary;
    @ApiModelProperty(name = "formalSalary", value = "转正后工薪", required = true)
    @NotNull(message = "请输入转正后工薪")
    private BigDecimal formalSalary;
    @ApiModelProperty(name = "insuranceCardinalType", value = "五险一金基数(0 最低标准 1 其他)", required = true)
    @NotNull(message = "请选择五险一金基数")
    private Integer insuranceCardinalType;
    @ApiModelProperty(name = "insuranceCardinalNumber", value = "缴纳基数", required = true)
    private Float insuranceCardinalNumber;
    @ApiModelProperty(name = "contractTypeId", value = "合同类型", required = true)
//    @NotNull(message = "请选择合同类型")
    private Integer contractTypeId;
    @ApiModelProperty(name = "contractTime", value = "合同时间长度", required = true)
    @NotNull(message = "请选择合同时间长度")
    private Integer contractTime;
    @ApiModelProperty(name = "specialRemark", value = "特殊事项备注", required = true)
    private String specialRemark;
    @ApiModelProperty(name = "employeeId", value = "审批人", required = true)
    @NotBlank(message = "请选择审批人")
    private String approverIds;
    @ApiModelProperty(name = "employeeId", value = "抄送人", required = true)
    private String ccIds;

}
