package com.xy.wwoa.employee.controller;

import com.xy.wwoa.common.api.PageResult;
import com.xy.wwoa.common.api.Result;
import com.xy.wwoa.common.api.ResultCode;
import com.xy.wwoa.common.util.PageUtil;
import com.xy.wwoa.employee.api.ApprovalEmployeeList;
import com.xy.wwoa.employee.api.ApprovalEmployeeModel;
import com.xy.wwoa.employee.model.ApprovalEmployee;
import com.xy.wwoa.employee.request.ApprovalEmployeeModifyRequest;
import com.xy.wwoa.employee.request.ApprovalEmployeeSaveRequest;
import com.xy.wwoa.employee.service.ApprovalEmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @Author leisurexi
 * @Description
 * @Date 2019/8/27
 * @Time 15:06
 */
@RestController
@RequestMapping("approvalType")
@Api(value = "部门审批人员接口", produces = "application/json")
@Validated
public class ApprovalEmployeeController {

    @Autowired
    private ApprovalEmployeeService approvalEmployeeService;

    @ApiOperation(value = "根据部门id获取部门审批人员信息", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "organizationId", value = "部门id", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "page", value = "当前页", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "每页显示的数量", dataType = "int", paramType = "query"),
    })
    @GetMapping("listApprovalEmployee")
    public PageResult<ApprovalEmployeeModel> listApprovalEmployee(@NotNull(message = "请选择部门") Integer organizationId, Integer page, Integer size) {
        ApprovalEmployeeList employeeList = approvalEmployeeService.listApprovalEmployee(organizationId, page == null ? PageUtil.PAGE_DEFAULT : page, size == null ? PageUtil.SIZE_DEFAULT : size);
        return PageResult.<ApprovalEmployeeModel>builder()
                .data(employeeList.getList())
                .total(employeeList.getTotal())
                .page(employeeList.getPage())
                .build();
    }

    @ApiOperation(value = "添加部门审批人员信息", httpMethod = "POST")
    @PostMapping("save")
    public Result save(@ModelAttribute @Valid ApprovalEmployeeSaveRequest saveRequest) {
        ApprovalEmployee model = new ApprovalEmployee();
        BeanUtils.copyProperties(saveRequest, model);
        model.setStatus(1);
        boolean result = approvalEmployeeService.save(model);
        if (result) {
            return Result.builder().build();
        }
        return Result.builder()
                .data(ResultCode.SAVE_ERROR)
                .build();
    }

    @ApiOperation(value = "删除部门审批人员信息", httpMethod = "POST")
    @PostMapping("remove")
    public Result remove(@NotNull(message = "请选择部门审批人员") Integer id) {
        boolean result = approvalEmployeeService.remove(id);
        if (result) {
            return Result.builder().build();
        }
        return Result.builder()
                .data(ResultCode.REMOVE_ERROR)
                .build();
    }

    @ApiOperation(value = "编辑部门审批人员信息", httpMethod = "POST")
    @PostMapping("modify")
    public Result modify(@ModelAttribute @Valid ApprovalEmployeeModifyRequest modifyRequest) {
        ApprovalEmployee model = new ApprovalEmployee();
        BeanUtils.copyProperties(modifyRequest, model);
        boolean result = approvalEmployeeService.modify(model);
        if (result) {
            return Result.builder().build();
        }
        return Result.builder()
                .data(ResultCode.REMOVE_ERROR)
                .build();
    }

}
