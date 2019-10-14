package com.xy.wwoa.setting.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Author 陈璇
 * @Description ModifyFixedcostsCategoryRequest
 * @date 2019/8/29 9:00
 */
@Data
@ToString
@ApiModel(value = "编辑固定费用类别参数对象")
public class ModifyFixedcostsCategoryRequest {

    @ApiModelProperty(name = "id", value = "固定费用类别id", required = true, dataType = "int")
    @NotNull(message = "请选择固定费用类别id")
    private Integer id;
    @ApiModelProperty(name = "category", value = "固定费用类别内容", required = true, dataType = "string")
    @NotBlank(message = "请输入固定费用类别")
    private String category;
    @ApiModelProperty(name = "status", value = "固定费用类别状态", required = true, dataType = "int")
    @NotNull(message = "请选择固定费用类别状态")
    private Integer status;
    @ApiModelProperty(name = "remark", value = "备注", dataType = "string")
    private String remark;

}
