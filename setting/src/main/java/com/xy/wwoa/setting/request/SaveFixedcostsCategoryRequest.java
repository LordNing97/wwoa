package com.xy.wwoa.setting.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Author 陈璇
 * @Description SaveFixedcostsCategoryRequest
 * @date 2019/8/28 17:29
 */
@Data
@ToString
@ApiModel(value = "保存固定费用类别参数对象")
public class SaveFixedcostsCategoryRequest {

    @ApiModelProperty(name = "category", value = "固定费用类别内容", required = true, dataType = "string")
    @NotBlank(message = "请输入固定费用类别")
    private String category;
    @ApiModelProperty(name = "status", value = "固定费用类别状态", required = true, dataType = "int")
    @NotNull(message = "请选择固定费用类别状态")
    private Integer status;
    @ApiModelProperty(name = "remark", value = "备注", dataType = "string")
    private String remark;

}
