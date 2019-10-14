package com.xy.wwoa.approval.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;


/**
 * @Author leisurexi
 * @Description
 * @Date 2019/8/31
 * @Time 15:36
 */
@Data
@ToString
@ApiModel(value = "保存通用审批参数对象")
public class SaveInterchangeableApprovalRequest {

    @ApiModelProperty(name = "applyContent", value = "申请内容", required = true, dataType = "string")
    @NotBlank(message = "请输入申请内容")
    private String applyContent;
    @ApiModelProperty(name = "approvalDetail", value = "审批详情", required = true, dataType = "string")
    @NotBlank(message = "请输入审批详情")
    @Length(max = 200, message = "审批详情内容最大长度200")
    private String approvalDetail;
    @ApiModelProperty(name = "approverIds", value = "审批人", required = true, dataType = "string")
    @NotBlank(message = "请选择审批人")
    private String approverIds;
    @ApiModelProperty(name = "ccIds", value = "抄送人", required = true, dataType = "string")
    private String ccIds;
    @ApiModelProperty(name = "imgs", value = "图片")
    private String imgs;

}
