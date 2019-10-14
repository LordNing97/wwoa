package com.xy.wwoa.setting.controller;

import com.xy.wwoa.common.api.PageResult;
import com.xy.wwoa.common.api.Result;
import com.xy.wwoa.common.api.ResultCode;
import com.xy.wwoa.common.util.PageUtil;
import com.xy.wwoa.setting.api.IncreasedTaxRateList;
import com.xy.wwoa.setting.model.IncreasedTaxRate;
import com.xy.wwoa.setting.request.ModifyIncreasedTaxRateRequest;
import com.xy.wwoa.setting.request.SaveIncreasedTaxRateRequest;
import com.xy.wwoa.setting.service.IncreasedTaxRateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @Author 陈璇
 * @Description IncreasedTaxRateController
 * @date 2019/8/29 14:59
 */
@RestController
@RequestMapping("increasedTaxRate")
@Validated
@Api(value = "增票税率接口", produces = "application/json")
public class IncreasedTaxRateController {

    @Resource
    private IncreasedTaxRateService increasedTaxRateService;

    @ApiOperation(value = "保存增票税率", httpMethod = "POST")
    @PostMapping("save")
    public Result save(@ModelAttribute @Valid SaveIncreasedTaxRateRequest saveIncreasedTaxRateRequest){
        IncreasedTaxRate increasedTaxRate = new IncreasedTaxRate();
        BeanUtils.copyProperties(saveIncreasedTaxRateRequest, increasedTaxRate);
        boolean result = increasedTaxRateService.save(increasedTaxRate);
        if(result){
            return Result.builder().build();
        }
        return Result.builder(ResultCode.SAVE_ERROR).build();
    }

    @ApiOperation(value = "编辑增票税率", httpMethod = "POST")
    @PostMapping("modify")
    public Result modify(@ModelAttribute @Valid ModifyIncreasedTaxRateRequest modifyIncreasedTaxRateRequest){
        IncreasedTaxRate increasedTaxRate = new IncreasedTaxRate();
        BeanUtils.copyProperties(modifyIncreasedTaxRateRequest,increasedTaxRate);
        boolean result = increasedTaxRateService.modify(increasedTaxRate);
        if(result){
            return Result.builder().build();
        }
        return Result.builder(ResultCode.SAVE_ERROR).build();
    }

    @ApiOperation(value = "删除增票税率", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "int", paramType = "query")
    })
    @PostMapping("delete")
    public Result delete(@NotNull Integer id){
        boolean result = increasedTaxRateService.delete(id);
        if(result){
            return Result.builder().build();
        }
        return Result.builder(ResultCode.REMOVE_ERROR).build();
    }

    @ApiOperation(value = "分页获取增票税率", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "taxRate", value = "增票税率税率",dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "status", value = "状态",dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "page", value = "当前页",dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "每页显示的数量",dataType = "int", paramType = "query")
    })
    @GetMapping("listIncreasedTaxRate")
    public PageResult listIncreasedTaxRate(String taxRate, Integer status, Integer page, Integer size){
        IncreasedTaxRateList increasedTaxRateList = increasedTaxRateService.listIncreasedTaxRate(taxRate, status, page == null ? PageUtil.PAGE_DEFAULT : page, size == null ? PageUtil.SIZE_DEFAULT : size);
        return PageResult.<IncreasedTaxRate>builder()
                .data(increasedTaxRateList.getList())
                .page(increasedTaxRateList.getPage())
                .total(increasedTaxRateList.getTotal())
                .build();
    }

    @ApiOperation(value = "根据ID获取增票税率", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "int", paramType = "query")
    })
    @GetMapping("findById")
    public Result findById(@NotNull Integer id){
        return Result.builder()
                .data(increasedTaxRateService.findById(id))
                .build();
    }

}
