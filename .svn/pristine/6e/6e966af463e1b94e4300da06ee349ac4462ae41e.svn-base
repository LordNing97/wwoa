package com.xy.wwoa.setting.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

/**
 * @Author 陈璇
 * @Description SaveCompanyRequest
 * @date 2019/8/30 9:12
 */
@Data
@ToString
@ApiModel(value = "保存公司参数对象")
public class SaveCompanyRequest {

    @ApiModelProperty(name = "name", value = "公司名称", required = true, dataType = "string")
    @NotBlank(message = "请输入公司名称")
    private String name;
    @ApiModelProperty(name = "telephone", value = "公司电话", required = true, dataType = "string")
    @NotBlank(message = "请输入公司电话")
    private String telephone;
    @ApiModelProperty(name = "dutyParagraph", value = "税号", required = true, dataType = "string")
    @NotBlank(message = "请输入税号")
    private String dutyParagraph;
    @ApiModelProperty(name = "address", value = "公司地址", required = true, dataType = "string")
    @NotBlank(message = "请输入公司地址")
    private String address;
    @ApiModelProperty(name = "openingBank", value = "开户行", required = true, dataType = "string")
    @NotBlank(message = "请输入开户行")
    private String openingBank;
    @ApiModelProperty(name = "openingBank", value = "账号", required = true, dataType = "string")
    @NotBlank(message = "请输入账号")
    private String accountNumber;
    @ApiModelProperty(name = "remark", value = "备注", dataType = "string")
    private String remark;

}
