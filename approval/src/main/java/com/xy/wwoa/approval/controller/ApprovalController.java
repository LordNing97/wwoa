package com.xy.wwoa.approval.controller;

import com.xy.wwoa.approval.api.ApprovalDetailModel;
import com.xy.wwoa.approval.api.ApprovalModel;
import com.xy.wwoa.approval.service.ApprovalService;
import com.xy.wwoa.common.api.Result;
import com.xy.wwoa.common.api.ResultCode;
import com.xy.wwoa.employee.model.Employee;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Author leisurexi
 * @Description
 * @Date 2019/8/28
 * @Time 17:23
 */
@RestController
@RequestMapping("approval")
@Api(value = "审批接口", produces = "application/json")
@Validated
public class ApprovalController {

    @Autowired
    private ApprovalService approvalService;

    @ApiOperation(value = "待处理审批信息", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "searchCondition", value = "搜索条件", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "approvalTypeId", value = "审批类型Id(全部传-1)", dataType = "int", paramType = "query"),
    })
    @GetMapping("pendingApproval")
    public Result<List<ApprovalModel>> pendingApproval(@ApiIgnore Employee employee, String searchCondition, Integer approvalTypeId) {
        return Result.<List<ApprovalModel>>builder()
                .data(approvalService.pendingApproval(employee.getId(), searchCondition, approvalTypeId))
                .build();
    }

    @ApiOperation(value = "已处理审批信息", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "searchCondition", value = "搜索条件", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "approvalTypeId", value = "审批类型Id(全部传-1)", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "status", value = "状态(-1 全部 0 审批中 1/2 审批完成 3 已撤销)", dataType = "int", paramType = "query"),
    })
    @GetMapping("processed")
    public Result<List<ApprovalModel>> processed(@ApiIgnore Employee employee, String searchCondition, Integer approvalTypeId, Integer status) {
        return Result.<List<ApprovalModel>>builder()
                .data(approvalService.processed(employee.getId(), searchCondition, approvalTypeId, status))
                .build();
    }

    @ApiOperation(value = "待处理审批详情", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "approvalNumber", value = "审批编号", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "approvalTypeId", value = "审批类型Id", required = true, dataType = "int", paramType = "query"),
    })
    @GetMapping("approvalDetail")
    public Result<ApprovalDetailModel> approvalDetail(@NotBlank String approvalNumber, @NotNull Integer approvalTypeId) {
        return Result.<ApprovalDetailModel>builder()
                .data(approvalService.approvalDetail(approvalNumber, approvalTypeId))
                .build();
    }

    @ApiOperation(value = "审批", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "approvalNumber", value = "审批编号", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "approvalTypeId", value = "审批类型Id", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "result", value = "审核结果(1 同意 2 拒绝 3 撤销)", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "approvalOpinion", value = "审核意见", dataType = "string", paramType = "query"),
    })
    @PostMapping("approval")
    public Result approval(@ApiIgnore Employee employee, @NotBlank String approvalNumber, @NotNull Integer approvalTypeId, @NotNull Integer result, String approvalOpinion) {
        boolean approval = approvalService.approval(employee.getId(), approvalNumber, approvalTypeId, result, approvalOpinion);
        if (approval) {
            return Result.builder().build();
        }
        return Result.builder(ResultCode.SAVE_ERROR)
                .build();
    }

    @ApiOperation(value = "我发起的", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "searchCondition", value = "搜索条件", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "approvalTypeId", value = "审批类型Id(全部传-1)", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "status", value = "状态(-1 全部 0 审批中 1/2 审批完成 3 已撤销)", dataType = "int", paramType = "query"),
    })
    @GetMapping("iSubmitted")
    public Result<List<ApprovalModel>> iSubmitted(@ApiIgnore Employee employee, String searchCondition, Integer approvalTypeId, Integer status) {
        return Result.<List<ApprovalModel>>builder()
                .data(approvalService.iSubmitted(employee.getId(), searchCondition, approvalTypeId, status))
                .build();
    }

    @ApiOperation(value = "抄送我的", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ccStatus", value = "是否是未读(0是 1否)", dataType = "int", required = true, paramType = "query"),
            @ApiImplicitParam(name = "searchCondition", value = "搜索条件", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "approvalTypeId", value = "审批类型Id(全部传-1)", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "status", value = "状态(-1 全部 0 审批中 1/2 审批完成 3 已撤销)", dataType = "int", paramType = "query"),
    })
    @GetMapping("ccMy")
    public Result<List<ApprovalModel>> ccMy(@ApiIgnore Employee employee, Integer ccStatus, String searchCondition, Integer approvalTypeId, Integer status) {
        return Result.<List<ApprovalModel>>builder()
                .data(approvalService.ccMy(employee.getId(), ccStatus, searchCondition, approvalTypeId, status))
                .build();
    }

    @ApiOperation(value = "将抄送修改为已读", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "ids", value = "抄送ids(多个id用逗号隔开)", dataType = "string", required = true, paramType = "query"),
    })
    @PostMapping("modifyCcStatus")
    public Result modifyCcStatus(String ids) {
        boolean result = approvalService.modifyCcStatus(ids);
        if (result) {
            return Result.builder().build();
        }
        return Result.builder(ResultCode.SAVE_ERROR)
                .build();
    }

}
