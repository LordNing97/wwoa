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
 * @Date 2019/9/5
 * @Time 14:07
 */
@Data
@ToString
@ApiModel(value = "保存合同审批参数对象")
public class SaveContractApprovalRequest {

    @ApiModelProperty(name = "organizationId", value = "部门id", required = true)
    @NotNull(message = "请选择部门")
    private Integer organizationId;
    @ApiModelProperty(name = "contractNumber", value = "合同编号", required = true)
    @NotBlank(message = "请输入合同编号")
    private String contractNumber;
    @ApiModelProperty(name = "contractTypeId", value = "合同类型", required = true)
    @NotNull(message = "请选择合同类型")
    private Integer contractTypeId;
    @ApiModelProperty(name = "contractNumber", value = "签约时间", required = true)
    @NotNull(message = "请输入签约时间")
    private LocalDateTime signingTime;
    @ApiModelProperty(name = "contractNumber", value = "合同金额", required = true)
    @NotNull(message = "请输入合同金额")
    private BigDecimal contractMoney;
    @ApiModelProperty(name = "ourSideCompanyName", value = "我方单位名称", required = true)
    @NotBlank(message = "请输入我方单位名称")
    private String ourSideCompanyName;
    @ApiModelProperty(name = "salesPrincipal", value = "销售负责人", required = true)
    @NotBlank(message = "请输入销售负责人")
    private String salesPrincipal;
    @ApiModelProperty(name = "otherSideCompanyName", value = "对方单位名称", required = true)
    @NotBlank(message = "请输入对方单位名称")
    private String otherSideCompanyName;
    @ApiModelProperty(name = "customerContact", value = "客户联系人", required = true)
    @NotBlank(message = "请输入客户联系人")
    private String customerContact;
    @ApiModelProperty(name = "imgs", value = "图片")
    private String imgs;
    @ApiModelProperty(name = "annexs", value = "附件")
    private String annexs;
    @ApiModelProperty(name = "approverIds", value = "审批人ids", required = true)
    @NotBlank(message = "请选择审批人")
    private String approverIds;
    @ApiModelProperty(name = "ccIds", value = "抄送人ids")
    private String ccIds;
    @ApiModelProperty(name = "contractTermJson", value = "合同条款", required = true)
    @NotBlank(message = "请输入合同条款")
    private String contractTermJson;

}
