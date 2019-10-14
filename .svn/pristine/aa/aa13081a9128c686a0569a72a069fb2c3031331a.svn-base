package com.xy.wwoa.setting.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Author 陈璇
 * @Description SaveIncreasedTaxRateRequest
 * @date 2019/8/29 14:48
 */
@Data
@ToString
@ApiModel(value = "保存增票税率参数对象")
public class SaveIncreasedTaxRateRequest {

    @ApiModelProperty(name = "taxRate", value = "增票税率税率", required = true, dataType = "string")
    @NotBlank(message = "请输入增票税率税率")
    private String taxRate;
    @ApiModelProperty(name = "status", value = "增票税率状态", required = true, dataType = "int")
    @NotNull(message = "请选择增票税率状态")
    private Integer status;
    @ApiModelProperty(name = "describe", value = "描述", dataType = "string")
    private String describe;

}
