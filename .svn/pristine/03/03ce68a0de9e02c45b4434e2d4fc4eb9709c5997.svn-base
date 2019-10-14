package com.xy.wwoa.approval.controller;

import com.xy.wwoa.approval.api.LeaveApprovalList;
import com.xy.wwoa.approval.api.LeaveApprovalModal;
import com.xy.wwoa.approval.model.LeaveApproval;
import com.xy.wwoa.approval.request.ListLeaveApprovalRequest;
import com.xy.wwoa.approval.request.SaveLeaveApprovalRequest;
import com.xy.wwoa.approval.service.LeaveApprovalService;
import com.xy.wwoa.common.api.PageResult;
import com.xy.wwoa.common.api.Result;
import com.xy.wwoa.common.util.PageUtil;
import com.xy.wwoa.employee.model.Employee;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @Author 陈璇
 * @Description LeaveApprovalController
 * @date 2019/8/31 10:43
 */
@RestController
@RequestMapping("leaveApproval")
@Validated
@Api(value = "离职审批接口", produces = "application/json")
public class LeaveApprovalController {

    @Resource
    private LeaveApprovalService leaveApprovalService;

    @ApiOperation(value = "添加员工离职审批信息", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "approvalTypeId", value = "审批类型id", required = true, dataType = "int", paramType = "query"),
    })
    @PostMapping("save")
    public Result save(@ApiIgnore Employee employee,@ModelAttribute @Valid SaveLeaveApprovalRequest saveLeaveApprovalRequest,@NotNull Integer approvalTypeId){
        LeaveApproval leaveApproval = new LeaveApproval();
        BeanUtils.copyProperties(saveLeaveApprovalRequest,leaveApproval);
        leaveApprovalService.save(employee.getId(),leaveApproval,approvalTypeId);
        return Result.builder().build();
    }

    @ApiOperation(value = "后台 人事管理-离职审批列表", httpMethod = "POST")
    @PostMapping("listLeaveApproval")
    public PageResult listLeaveApproval(@ModelAttribute ListLeaveApprovalRequest listLeaveApprovalRequest){
        LeaveApprovalList leaveApprovalList = leaveApprovalService.listLeaveApproval(listLeaveApprovalRequest.getOrganizationId(), listLeaveApprovalRequest.getJobId(),
                listLeaveApprovalRequest.getEmployeeName(), listLeaveApprovalRequest.getIdcard(), listLeaveApprovalRequest.getStatus() ,
                listLeaveApprovalRequest.getPage() == null ? PageUtil.PAGE_DEFAULT : listLeaveApprovalRequest.getPage(), listLeaveApprovalRequest.getSize() == null ? PageUtil.SIZE_DEFAULT : listLeaveApprovalRequest.getSize());
        return PageResult.<LeaveApprovalModal>builder()
                .data(leaveApprovalList.getList())
                .page(leaveApprovalList.getPage())
                .total(leaveApprovalList.getTotal())
                .build();
    }

}
