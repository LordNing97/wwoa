package com.xy.wwoa.approval.controller;

import com.xy.wwoa.approval.api.RenewApprovalList;
import com.xy.wwoa.approval.api.RenewApprovalModel;
import com.xy.wwoa.approval.model.RenewApproval;
import com.xy.wwoa.approval.request.ListEntryApprovalRequest;
import com.xy.wwoa.approval.request.SaveRenewApprovalRequest;
import com.xy.wwoa.approval.service.RenewApprovalService;
import com.xy.wwoa.common.api.PageResult;
import com.xy.wwoa.common.api.Result;
import com.xy.wwoa.common.api.ResultCode;
import com.xy.wwoa.common.util.PageUtil;
import com.xy.wwoa.employee.model.Employee;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: leisurexi
 * Date: 2019-08-27
 * Time: 22:51
 */
@RestController
@RequestMapping("renewApproval")
@Api(value = "合同续签审批接口", produces = "application/json")
@Validated
public class RenewApprovalController {

    @Autowired
    private RenewApprovalService renewApprovalService;

    @ApiOperation(value = "添加合同续签审批信息", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "approvalTypeId", value = "审批类型id", required = true, dataType = "int", paramType = "query"),
    })
    @PostMapping("save")
    public Result save(@ApiIgnore Employee employee, @ModelAttribute @Valid SaveRenewApprovalRequest saveRequest, @NotNull Integer approvalTypeId) {
        RenewApproval renewApproval = new RenewApproval();
        BeanUtils.copyProperties(saveRequest, renewApproval);
        boolean result = renewApprovalService.save(employee.getId(), renewApproval, approvalTypeId);
        if (result) {
            return Result.builder().build();
        }
        return Result.builder(ResultCode.SAVE_ERROR).build();
    }

    @ApiOperation(value = "后台 人事管理-合同审批列表", httpMethod = "POST")
    @PostMapping("listEntryApproval")
    public PageResult<RenewApprovalModel> listEntryApproval(@ModelAttribute ListEntryApprovalRequest listRequest) {
        RenewApprovalList renewApprovalList = renewApprovalService.listContractApproval(listRequest.getOrganizationId(), listRequest.getJobId(), listRequest.getName(), listRequest.getTelephone(),
                listRequest.getStatus(), listRequest.getPage() == null ? PageUtil.PAGE_DEFAULT : listRequest.getPage(), listRequest.getSize() == null ? PageUtil.SIZE_DEFAULT : listRequest.getSize());
        return PageResult.<RenewApprovalModel>builder()
                .data(renewApprovalList.getList())
                .page(renewApprovalList.getPage())
                .total(renewApprovalList.getTotal())
                .build();
    }


}
