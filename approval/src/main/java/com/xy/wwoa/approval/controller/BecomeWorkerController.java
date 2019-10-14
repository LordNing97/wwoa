package com.xy.wwoa.approval.controller;

import com.xy.wwoa.approval.api.BecomeWorkerList;
import com.xy.wwoa.approval.api.BecomeWorkerModal;
import com.xy.wwoa.approval.request.SaveBecomeWorkerRequest;
import com.xy.wwoa.approval.service.BecomeWorkerService;
import com.xy.wwoa.common.api.PageResult;
import com.xy.wwoa.common.api.Result;
import com.xy.wwoa.common.util.PageUtil;
import com.xy.wwoa.employee.model.Employee;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
 * @Author 陈璇
 * @Description BecomeWorkerController
 * @date 2019/9/2 16:56
 */
@RestController
@RequestMapping("becomeWorker")
@Validated
@Api(value = "转正审批接口", produces = "application/json")
public class BecomeWorkerController {

    @Resource
    private BecomeWorkerService becomeWorkerService;

    @ApiOperation(value = "添加转正审批审批信息", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "approvalTypeId", value = "审批类型id", required = true, dataType = "int", paramType = "query"),
    })
    @PostMapping("save")
    public Result save(@ApiIgnore Employee employee, @ModelAttribute @Valid SaveBecomeWorkerRequest saveBecomeWorkerRequest,@NotNull Integer approvalTypeId){
        becomeWorkerService.save(employee.getId(), saveBecomeWorkerRequest, approvalTypeId);
        return Result.builder().build();
    }

    @ApiOperation(value = "判断员工是否转正(0 未转正 1 已转正)", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "employeeId", value = "员工id", required = true, dataType = "int", paramType = "query"),
    })
    @PostMapping("isPositive")
    public Result isPositive(@NotNull Integer employeeId){
        int positive = becomeWorkerService.isPositive(employeeId);
        return Result.builder()
                .data(positive)
                .build();
    }

    @ApiOperation(value = "后台 人事管理-转正审批列表", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "organizationId", value = "部门id", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "jobId", value = "岗位id", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "employeeName", value = "员工姓名", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "idcard", value = "身份证号", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "page", value = "当前页", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "每页显示数量", dataType = "int", paramType = "query"),
    })
    @PostMapping("listBecomeWorker")
    public PageResult listBecomeWorker(Integer organizationId, Integer jobId, String employeeName, String idcard, Integer page, Integer size){
        BecomeWorkerList becomeWorkerList = becomeWorkerService.listBecomeWorker(organizationId, jobId, employeeName, idcard, page == null ? PageUtil.PAGE_DEFAULT : page,
                size == null ? PageUtil.SIZE_DEFAULT : size);
        return PageResult.<BecomeWorkerModal>builder()
                .data(becomeWorkerList.getList())
                .page(becomeWorkerList.getPage())
                .total(becomeWorkerList.getTotal())
                .build();
    }

    @ApiOperation(value = "后台 人事管理-转正审批详情信息", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "转正审批id", required = true, dataType = "int", paramType = "query"),
    })
    @PostMapping("detailedInformation")
    public Result detailedInformation(Integer id){
        return Result.builder()
                .data(becomeWorkerService.detailedInformation(id))
                .build();
    }

}
