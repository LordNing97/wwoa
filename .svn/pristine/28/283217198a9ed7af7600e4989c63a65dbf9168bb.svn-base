package com.xy.wwoa.approval.controller;

import com.xy.wwoa.approval.model.ApprovalType;
import com.xy.wwoa.approval.service.ApprovalTypeService;
import com.xy.wwoa.common.api.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author leisurexi
 * @Description
 * @Date 2019/8/27
 * @Time 14:49
 */
@RestController
@RequestMapping("approvalType")
@Api(value = "审批类型接口", produces = "application/json")
public class ApprovalTypeController {

    @Autowired
    private ApprovalTypeService approvalTypeService;

    @ApiOperation(value = "获取全部审批类型信息", httpMethod = "GET")
    @GetMapping("listApprovalType")
    public Result<List<ApprovalType>> listApprovalType() {
        return Result.<List<ApprovalType>>builder()
                .data(approvalTypeService.listApprovalType())
                .build();
    }


}
