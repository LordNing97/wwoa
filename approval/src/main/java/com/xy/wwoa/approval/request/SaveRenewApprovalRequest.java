package com.xy.wwoa.approval.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: leisurexi
 * Date: 2019-08-27
 * Time: 23:21
 */
@Data
@ToString
@ApiModel(value = "保存合同续签审批参数对象")
public class SaveRenewApprovalRequest {

    @ApiModelProperty(name = "approvalNumber", value = "审批编号", required = true)
    @NotBlank
    private String approvalNumber;
    @ApiModelProperty(name = "actualApplicantId", value = "实际申请人id", required = true)
    @NotNull
    private Integer actualApplicantId;
//    @ApiModelProperty(name = "organizationId", value = "部门id", required = true, dataType = "int")
//    @NotNull
//    private Integer organizationId;
//    @ApiModelProperty(name = "jobId", value = "岗位id", required = true, dataType = "int")
//    @NotNull
//    private Integer jobId;
    @ApiModelProperty(name = "contractTime", value = "合同到期时间", required = true)
    @NotNull(message = "请输入合同到期时间")
    private LocalDateTime maturityTime;
    @ApiModelProperty(name = "renewSalary", value = "续签薪资", required = true)
    @NotNull(message = "请输入续签薪资")
    private BigDecimal renewSalary;
    @ApiModelProperty(name = "workShow", value = "工作表现", required = true)
    @NotBlank(message = "请输入工作表现")
    @Length(max = 200, message = "工作表现内容最大长度为200")
    private String workShow;
    @ApiModelProperty(name = "performance", value = "业绩", required = true)
    @NotBlank(message = "请输入业绩")
    @Length(max = 200, message = "业绩内容最大长度为200")
    private String performance;
    @ApiModelProperty(name = "approverIds", value = "审批人ids", required = true)
    @NotBlank(message = "请选择审批人")
    private String approverIds;
    @ApiModelProperty(name = "ccIds", value = "抄送人ids")
    private String ccIds;

}
