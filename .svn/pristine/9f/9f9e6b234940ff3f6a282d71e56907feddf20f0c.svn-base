package com.xy.wwoa.approval.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * @Author 陈璇
 * @Description SaveWorkSummaryRequest
 * @date 2019/8/31 17:06
 */
@Data
@ToString
@ApiModel(value = "保存工作总结参数对象")
public class SaveWorkSummaryRequest {

    @ApiModelProperty(name = "workContent", value = "工作内容", required = true, dataType = "string")
    @NotBlank(message = "请输入工作内容")
    @Length(min = 1, max = 200, message = "工作内容不能超过200个字符")
    private String workContent;
    @ApiModelProperty(name = "ccIds", value = "抄送人", required = true, dataType = "string")
    private String ccIds;

}
