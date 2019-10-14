package com.xy.wwoa.approval.controller;

import com.xy.wwoa.approval.api.WorkSummaryList;
import com.xy.wwoa.approval.api.WorkSummaryModal;
import com.xy.wwoa.approval.model.WorkSummary;
import com.xy.wwoa.approval.request.SaveWorkSummaryRequest;
import com.xy.wwoa.approval.service.WorkSummaryService;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Author 陈璇
 * @Description WorkSummaryController
 * @date 2019/8/31 17:04
 */
@RestController
@RequestMapping("workSummary")
@Validated
@Api(value = "工作总结接口", produces = "application/json")
public class WorkSummaryController {

    @Resource
    private WorkSummaryService workSummaryService;

    @ApiOperation(value = "添加工作总结审批信息", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "approvalTypeId", value = "审批类型id", required = true, dataType = "int", paramType = "query"),
    })
    @PostMapping("save")
    public Result save(@ApiIgnore Employee employee, @ModelAttribute @Valid SaveWorkSummaryRequest saveWorkSummaryRequest,@NotNull Integer approvalTypeId){
        WorkSummary workSummary = new WorkSummary();
        BeanUtils.copyProperties(saveWorkSummaryRequest,workSummary);
        workSummaryService.save(employee,workSummary,approvalTypeId);
        return Result.builder().build();
    }

    @ApiOperation(value = "后台 人事管理-工作总结列表", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "organizationId", value = "部门id", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "employeeName", value = "员工姓名", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "workContent", value = "工作内容", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "page", value = "当前页", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "每页显示数量", dataType = "int", paramType = "query"),
    })
    @PostMapping("listWorkSummary")
    public PageResult listWorkSummary(Integer organizationId, String employeeName,String workContent,Integer page,Integer size){
        WorkSummaryList workSummaryList = workSummaryService.listWorkSummary(organizationId, employeeName, workContent, page == null ? PageUtil.PAGE_DEFAULT : page,
                size == null ? PageUtil.SIZE_DEFAULT : size);
        return PageResult.<WorkSummaryModal>builder()
                .data(workSummaryList.getList())
                .page(workSummaryList.getPage())
                .total(workSummaryList.getTotal())
                .build();
    }

    @ApiOperation(value = "后台 人事管理-工作总结审批详情信息", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "工作总结审批id", required = true, dataType = "int", paramType = "query"),
    })
    @PostMapping("detailedInformation")
    public Result detailedInformation(@NotNull Integer id){
        return Result.builder()
                .data(workSummaryService.detailedInformation(id))
                .build();
    }


}
