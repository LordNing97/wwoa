package com.xy.wwoa.setting.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @Author 陈璇
 * @Description ModifyReimbursementCategoryRequest
 * @date 2019/8/28 14:55
 */
@Data
@ToString
@ApiModel(value = "编辑报销类别参数对象")
public class ModifyReimbursementCategoryRequest {

    @ApiModelProperty(name = "id", value = "报销类别id", required = true, dataType = "int")
    @NotNull
    private Integer id;
    @ApiModelProperty(name = "category", value = "报销类别内容", required = true, dataType = "string")
    @NotBlank(message = "请输入报销类别")
    private String category;
    @ApiModelProperty(name = "status", value = "报销类别状态", required = true, dataType = "int")
    @NotNull(message = "请选择报销类别状态")
    private Integer status;
    @ApiModelProperty(name = "remark", value = "备注", dataType = "string")
    private String remark;

}
