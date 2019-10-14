package com.xy.wwoa.employee.controller;

import com.xy.wwoa.employee.model.Organization;
import com.xy.wwoa.employee.service.OrganizationService;
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
 * @Time 9:38
 */
@RestController
@RequestMapping("organization")
@Api(value = "部门接口", produces = "application/json")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @ApiOperation(value = "获取全部部门信息", httpMethod = "GET")
    @GetMapping("listOrganization")
    public Result<List<Organization>> listOrganization() {
        return Result.<List<Organization>>builder()
                .data(organizationService.listOrganization())
                .build();
    }

}
