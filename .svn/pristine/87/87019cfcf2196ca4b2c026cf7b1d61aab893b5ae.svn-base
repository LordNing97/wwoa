package com.xy.wwoa.approval.controller;

import com.xy.wwoa.approval.api.EntryApprovalList;
import com.xy.wwoa.approval.api.EntryApprovalModel;
import com.xy.wwoa.approval.model.EntryApproval;
import com.xy.wwoa.approval.request.ListEntryApprovalRequest;
import com.xy.wwoa.approval.request.SaveEntryApprovalRequest;
import com.xy.wwoa.approval.request.SaveNewEmployeeEntryApprovalRequest;
import com.xy.wwoa.approval.service.EntryApprovalService;
import com.xy.wwoa.common.api.PageResult;
import com.xy.wwoa.common.api.Result;
import com.xy.wwoa.common.util.JSONUtil;
import com.xy.wwoa.common.util.PageUtil;
import com.xy.wwoa.employee.model.*;
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
 * @Author leisurexi
 * @Description
 * @Date 2019/8/28
 * @Time 11:19
 */
@RestController
@RequestMapping("entryApproval")
@Api(value = "入职审批接口", produces = "application/json")
@Validated
public class EntryApprovalController {

    @Autowired
    private EntryApprovalService entryApprovalService;

    @ApiOperation(value = "添加员工入职审批信息", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "approvalTypeId", value = "审批类型id", required = true, dataType = "int", paramType = "query"),
    })
    @PostMapping("saveEntry")
    public Result saveEntry(@ApiIgnore Employee employee, @ModelAttribute @Valid SaveEntryApprovalRequest saveRequest, @NotNull Integer approvalTypeId) {
        if (saveRequest.getInsuranceCardinalNumber() == null) {
            saveRequest.setInsuranceCardinalNumber(20f);
        }
        EntryApproval entryApproval = new EntryApproval();
        EmployeeInformation employeeInformation = new EmployeeInformation();
        BeanUtils.copyProperties(saveRequest, entryApproval);
        BeanUtils.copyProperties(saveRequest, employeeInformation);
        entryApprovalService.saveEntry(employee.getId(), entryApproval, employeeInformation, approvalTypeId);
        return Result.builder().build();
    }

    @ApiOperation(value = "添加新员工入职审批信息", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "approvalTypeId", value = "审批类型id", required = true, dataType = "int", paramType = "query"),
    })
    @PostMapping("saveNewEmployeeEntry")
    public Result saveNewEmployeeEntry(@ModelAttribute @Valid SaveNewEmployeeEntryApprovalRequest saveRequest, @NotNull Integer approvalTypeId) {
        EntryApproval entryApproval = new EntryApproval();
        EmployeeInformation employeeInformation = new EmployeeInformation();
        employeeInformation.setEducationStatuses(JSONUtil.parseArray(saveRequest.getEducationStatusJson(), EducationStatus.class));
        employeeInformation.setFamilyStatuses(JSONUtil.parseArray(saveRequest.getFamilyStatusJson(), FamilyStatus.class));
        employeeInformation.setJobResumes(JSONUtil.parseArray(saveRequest.getJobResumeJson(), JobResume.class));
        BeanUtils.copyProperties(saveRequest, entryApproval);
        BeanUtils.copyProperties(saveRequest, employeeInformation);
        entryApprovalService.saveNewEmployeeEntry(entryApproval, employeeInformation, approvalTypeId);
        return Result.builder().build();
    }

    @ApiOperation(value = "后台 人事管理-入职审批列表", httpMethod = "POST")
    @PostMapping("listEntryApproval")
    public PageResult<EntryApprovalModel> listEntryApproval(@ModelAttribute ListEntryApprovalRequest listRequest) {
        EntryApprovalList entryApprovalList = entryApprovalService.listEntryApproval(listRequest.getOrganizationId(), listRequest.getJobId(), listRequest.getName(), listRequest.getTelephone(),
                listRequest.getStatus(), listRequest.getPage() == null ? PageUtil.PAGE_DEFAULT : listRequest.getPage(), listRequest.getSize() == null ? PageUtil.SIZE_DEFAULT : listRequest.getSize());
        return PageResult.<EntryApprovalModel>builder()
                .data(entryApprovalList.getList())
                .page(entryApprovalList.getPage())
                .total(entryApprovalList.getTotal())
                .build();
    }

}
