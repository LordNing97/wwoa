package com.xy.wwoa.approval.controller;

import com.xy.wwoa.approval.api.ContractApprovalList;
import com.xy.wwoa.approval.api.ContractApprovalModel;
import com.xy.wwoa.approval.model.ContractApproval;
import com.xy.wwoa.approval.request.ListContractApprovalRequest;
import com.xy.wwoa.approval.request.SaveContractApprovalRequest;
import com.xy.wwoa.approval.service.ContractApprovalService;
import com.xy.wwoa.common.api.PageResult;
import com.xy.wwoa.common.api.Result;
import com.xy.wwoa.common.api.ResultCode;
import com.xy.wwoa.common.util.JSONUtil;
import com.xy.wwoa.common.util.PageUtil;
import com.xy.wwoa.employee.model.Employee;
import com.xy.wwoa.setting.model.ContractTerms;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import netscape.javascript.JSUtil;
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
 * @Date 2019/9/5
 * @Time 14:04
 */
@RestController
@RequestMapping("contractApproval")
@Api(value = "合同审批接口", produces = "application/json")
@Validated
public class ContractApprovalController {

    @Resource
    private ContractApprovalService contractApprovalService;

    @ApiOperation(value = "添加合同续签审批信息", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "approvalTypeId", value = "审批类型id", required = true, dataType = "int", paramType = "query"),
    })
    @PostMapping("save")
    public Result save(@ApiIgnore Employee employee, @ModelAttribute @Valid SaveContractApprovalRequest saveRequest, @NotNull Integer approvalTypeId) {
        ContractApproval contractApproval = new ContractApproval();
        BeanUtils.copyProperties(saveRequest, contractApproval);
        contractApproval.setContractTerms(JSONUtil.parseArray(saveRequest.getContractTermJson(), ContractTerms.class));
        boolean result = contractApprovalService.save(employee.getId(), contractApproval, approvalTypeId);
        if (result) {
            return Result.builder().build();
        }
        return Result.builder(ResultCode.SAVE_ERROR).build();
    }

    @ApiOperation(value = "后台 项目管理-合同审批", httpMethod = "POST")
    @PostMapping("listEntryApproval")
    public PageResult<ContractApprovalModel> listEntryApproval(@ModelAttribute ListContractApprovalRequest listRequest) {
        ContractApprovalList renewApprovalList = contractApprovalService.listContractApproval(listRequest.getOrganizationId(), listRequest.getContractNumber(), listRequest.getContractTypeId(), listRequest.getSigningTime(),
                listRequest.getOurSideCompanyName(), listRequest.getOtherSideCompanyName(), listRequest.getPage() == null ? PageUtil.PAGE_DEFAULT : listRequest.getPage(), listRequest.getSize() == null ? PageUtil.SIZE_DEFAULT : listRequest.getSize());
        return PageResult.<ContractApprovalModel>builder()
                .data(renewApprovalList.getList())
                .page(renewApprovalList.getPage())
                .total(renewApprovalList.getTotal())
                .build();
    }

}
