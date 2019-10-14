package com.xy.wwoa.setting.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Author leisurexi
 * @Description
 * @Date 2019/8/28
 * @Time 9:49
 */
@Data
@ToString
@ApiModel(value = "保存合同类型参数对象")
public class SaveContractTypeRequest {

    @ApiModelProperty(name = "name", value = "合同类型名称", required = true, dataType = "string")
    @NotBlank(message = "请输入合同类型名称")
    private String name;
    @ApiModelProperty(name = "status", value = "合同类型状态", required = true, dataType = "int")
    @NotNull(message = "请输入合同类型状态")
    private Integer status;
    @ApiModelProperty(name = "remark", value = "备注", dataType = "string")
    private String remark;

}
