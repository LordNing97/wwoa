package com.xy.wwoa.setting.controller;

import com.xy.wwoa.common.api.PageResult;
import com.xy.wwoa.common.api.Result;
import com.xy.wwoa.common.api.ResultCode;
import com.xy.wwoa.common.util.PageUtil;
import com.xy.wwoa.setting.api.CompanyList;
import com.xy.wwoa.setting.model.Company;
import com.xy.wwoa.setting.request.ModifyCompanyRequest;
import com.xy.wwoa.setting.request.SaveCompanyRequest;
import com.xy.wwoa.setting.service.CompanyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @Author 陈璇
 * @Description CompanyController
 * @date 2019/8/30 9:19
 */
@RestController
@RequestMapping("company")
@Validated
@Api(value = "公司接口", produces = "application/json")
public class CompanyController {

    @Resource
    private CompanyService companyService;

    @ApiOperation(value = "保存公司", httpMethod = "POST")
    @PostMapping("save")
    public Result save(@ModelAttribute @Valid SaveCompanyRequest saveCompanyRequest){
        Company company = new Company();
        BeanUtils.copyProperties(saveCompanyRequest,company);
        company.setStatus(1);
        boolean result = companyService.save(company);
        if(result){
            return Result.builder().build();
        }
        return Result.builder(ResultCode.SAVE_ERROR).build();
    }

    @ApiOperation(value = "编辑公司", httpMethod = "POST")
    @PostMapping("modify")
    public Result modify(@ModelAttribute @Valid ModifyCompanyRequest modifyCompanyRequest){
        Company company = new Company();
        BeanUtils.copyProperties(modifyCompanyRequest,company);
        boolean result = companyService.modify(company);
        if(result){
            return Result.builder().build();
        }
        return Result.builder(ResultCode.SAVE_ERROR).build();
    }

    @ApiOperation(value = "删除公司", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "int", paramType = "query")
    })
    @PostMapping("delete")
    public Result delete(Integer id){
        boolean result = companyService.delete(id);
        if(result){
            return Result.builder().build();
        }
        return Result.builder(ResultCode.REMOVE_ERROR).build();
    }

    @ApiOperation(value = "分页获取公司", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "公司名称",dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "address", value = "公司地址",dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "page", value = "当前页",dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "每页显示的数量",dataType = "int", paramType = "query")
    })
    @GetMapping("listCompany")
    public PageResult listCompany(String name, String address, Integer page, Integer size){
        CompanyList companyList = companyService.listCompany(name, address ,page == null ? PageUtil.PAGE_DEFAULT : page, size == null ? PageUtil.SIZE_DEFAULT : size);
        return PageResult.<Company>builder()
                .data(companyList.getList())
                .total(companyList.getTotal())
                .page(companyList.getPage())
                .build();
    }

}
