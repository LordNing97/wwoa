package com.xy.wwoa.setting.controller;

import com.xy.wwoa.common.api.PageResult;
import com.xy.wwoa.common.api.Result;
import com.xy.wwoa.common.api.ResultCode;
import com.xy.wwoa.common.util.PageUtil;
import com.xy.wwoa.setting.api.ContractTypeList;
import com.xy.wwoa.setting.model.ContractType;
import com.xy.wwoa.setting.request.ModifyContractTypeRequest;
import com.xy.wwoa.setting.request.SaveContractTypeRequest;
import com.xy.wwoa.setting.service.ContractTypeService;
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
 * @Date 2019/8/28
 * @Time 9:45
 */
@RestController
@RequestMapping("contractType")
@Api(value = "合同类型接口", produces = "application/json")
@Validated
public class ContractTypeController {

    @Autowired
    private ContractTypeService contractTypeService;

    @ApiOperation(value = "保存合同类型", httpMethod = "POST")
    @PostMapping("save")
    public Result save(@ModelAttribute @Valid SaveContractTypeRequest saveRequest) {
        ContractType contractType = new ContractType();
        BeanUtils.copyProperties(saveRequest, contractType);
        boolean result = contractTypeService.save(contractType);
        if (result) {
            return Result.builder().build();
        }
        return Result.builder(ResultCode.SAVE_ERROR).build();
    }

    @ApiOperation(value = "删除合同类型", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "合同类型id", required = true, dataType = "int", paramType = "query"),
    })
    @PostMapping("remove")
    public Result remove(@NotNull Integer id) {
        boolean result = contractTypeService.remove(id);
        if (result) {
            return Result.builder().build();
        }
        return Result.builder(ResultCode.SAVE_ERROR).build();
    }

    @ApiOperation(value = "修改合同类型", httpMethod = "POST")
    @PostMapping("modify")
    public Result modify(@ModelAttribute @Valid ModifyContractTypeRequest modifyRequest) {
        ContractType contractType = new ContractType();
        BeanUtils.copyProperties(modifyRequest, contractType);
        boolean result = contractTypeService.modify(contractType);
        if (result) {
            return Result.builder().build();
        }
        return Result.builder(ResultCode.SAVE_ERROR).build();
    }

    @ApiOperation(value = "分页查询合同类型", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "合同类型名称", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "status", value = "合同类型状态", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "page", value = "当前页", dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "每页显示的数量", dataType = "int", paramType = "query"),
    })
    @GetMapping("listContractType")
    public PageResult listContractType(String name, Integer status, Integer page, Integer size) {
        ContractTypeList contractTypeList = contractTypeService.listContractType(name, status, page == null ? PageUtil.PAGE_DEFAULT : page, size == null ? PageUtil.SIZE_DEFAULT : size);
        return PageResult.<ContractType>builder()
                .data(contractTypeList.getList())
                .total(contractTypeList.getTotal())
                .page(contractTypeList.getPage())
                .build();
    }

    @ApiOperation(value = "查询所有启动的合同类型", httpMethod = "GET")
    @GetMapping("getAll")
    public Result getAll() {
        return Result.builder()
                .data(contractTypeService.getAll())
                .build();
    }


}
