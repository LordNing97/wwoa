package com.xy.wwoa.approval.controller;

import com.xy.wwoa.approval.api.InterchangeableApprovalList;
import com.xy.wwoa.approval.api.InterchangeableApprovalModal;
import com.xy.wwoa.approval.model.InterchangeableApproval;
import com.xy.wwoa.approval.request.SaveInterchangeableApprovalRequest;
import com.xy.wwoa.approval.service.InterchangeableApprovalService;
import com.xy.wwoa.common.api.PageResult;
import com.xy.wwoa.common.api.Result;
import com.xy.wwoa.common.api.ResultCode;
import com.xy.wwoa.common.util.PageUtil;
import com.xy.wwoa.employee.model.Employee;
import com.xy.wwoa.setting.api.IncreasedTaxRateList;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @Author leisurexi
 * @Description
 * @Date 2019/8/31
 * @Time 15:34
 */
@RestController
@RequestMapping("interchangeableApproval")
@Api(value = "通用审批接口", produces = "application/json")
@Validated
public class InterchangeableApprovalController {

    @Resource
    private InterchangeableApprovalService interchangeableApprovalService;

    @ApiOperation(value = "添加通用审批信息", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "approvalTypeId", value = "审批类型id", required = true, dataType = "int", paramType = "query"),
    })
    @PostMapping("save")
    public Result save(@ApiIgnore Employee employee, @ModelAttribute @Valid SaveInterchangeableApprovalRequest saveRequest, @NotNull Integer approvalTypeId) {
        InterchangeableApproval interchangeableApproval = new InterchangeableApproval();
        BeanUtils.copyProperties(saveRequest, interchangeableApproval);
        boolean result = interchangeableApprovalService.save(employee, interchangeableApproval, approvalTypeId);
        if (result) {
            return Result.builder().build();
        }
        return Result.builder(ResultCode.SAVE_ERROR).build();
    }

    @ApiOperation(value = "后台 人事管理-通用审批列表", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "organizationId", value = "部门id", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "employeeName", value = "员工姓名", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "applyContent", value = "审批内容", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "page", value = "当前页", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "每页显示数量", dataType = "int", paramType = "query"),
    })
    @PostMapping("listInterchangeableApproval")
    public PageResult listInterchangeableApproval(Integer organizationId, String employeeName, String applyContent, Integer page, Integer size){
        InterchangeableApprovalList interchangeableApprovalList = interchangeableApprovalService.listInterchangeableApproval(organizationId, employeeName, applyContent,
                page == null ? PageUtil.PAGE_DEFAULT : page, size == null ? PageUtil.SIZE_DEFAULT : size);
        return PageResult.<InterchangeableApprovalModal>builder()
                .data(interchangeableApprovalList.getList())
                .total(interchangeableApprovalList.getTotal())
                .page(interchangeableApprovalList.getPage())
                .build();
    }

}
