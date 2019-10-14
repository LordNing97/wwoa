package com.xy.wwoa.employee.controller;

import com.xy.wwoa.common.api.Result;
import com.xy.wwoa.employee.model.Province;
import com.xy.wwoa.employee.service.ProvinceService;
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
 * @Date 2019/8/30
 * @Time 11:45
 */
@RestController
@RequestMapping("province")
@Api(value = "岗位接口", produces = "application/json")
public class ProvinceController {

    @Autowired
    private ProvinceService provinceService;

    @ApiOperation(value = "获取全部岗位信息", httpMethod = "GET")
    @GetMapping("listProvince")
    public Result<List<Province>> listProvince() {
        return Result.<List<Province>>builder()
                .data(provinceService.listProvince())
                .build();
    }

}
