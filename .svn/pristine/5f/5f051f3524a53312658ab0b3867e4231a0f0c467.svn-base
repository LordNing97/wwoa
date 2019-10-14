package com.xy.wwoa.setting.controller;

import com.xy.wwoa.common.api.PageResult;
import com.xy.wwoa.common.api.Result;
import com.xy.wwoa.common.api.ResultCode;
import com.xy.wwoa.common.util.PageUtil;
import com.xy.wwoa.setting.api.ReimbursementCategoryList;
import com.xy.wwoa.setting.model.ReimbursementCategory;
import com.xy.wwoa.setting.request.ModifyReimbursementCategoryRequest;
import com.xy.wwoa.setting.request.SaveReimbursementCategoryRequest;
import com.xy.wwoa.setting.service.ReimbursementCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @Author 陈璇
 * @Description ReimbursementCategoryController
 * @date 2019/8/28 13:34
 */
@RestController
@RequestMapping("reimbursementCategory")
@Validated
@Api(value = "报销类别接口", produces = "application/json")
public class ReimbursementCategoryController {

    @Resource
    private ReimbursementCategoryService reimbursementCategoryService;

    @ApiOperation(value = "保存报销类别", httpMethod = "POST")
    @PostMapping("save")
    public Result save(@ModelAttribute @Valid SaveReimbursementCategoryRequest saveReimbursementCategoryRequest){
        ReimbursementCategory reimbursementCategory = new ReimbursementCategory();
        BeanUtils.copyProperties(saveReimbursementCategoryRequest,reimbursementCategory);
        boolean result = reimbursementCategoryService.save(reimbursementCategory);
        if(result){
            return Result.builder().build();
        }
        return Result.builder(ResultCode.SAVE_ERROR).build();
    }

    @ApiOperation(value = "分页查询报销类别", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "category", value = "报销类别内容",dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "status", value = "状态",dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "page", value = "当前页",dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "每页显示的数量",dataType = "int", paramType = "query")
    })
    @GetMapping("listReimbursementCategory")
    public PageResult<ReimbursementCategory> listReimbursementCategory(String category, Integer status, Integer page, Integer size){
        ReimbursementCategoryList reimbursementCategoryList = reimbursementCategoryService.listReimbursementCategory(category, status, page == null ? PageUtil.PAGE_DEFAULT : page, size == null ? PageUtil.SIZE_DEFAULT : size);
        return PageResult.<ReimbursementCategory>builder()
                .data(reimbursementCategoryList.getList())
                .total(reimbursementCategoryList.getTotal())
                .page(reimbursementCategoryList.getPage())
                .build();
    }

    @ApiOperation(value = "编辑报销类别", httpMethod = "POST")
    @PostMapping("modify")
    public Result modify(@ModelAttribute @Valid ModifyReimbursementCategoryRequest modifyReimbursementCategoryRequest){
        ReimbursementCategory reimbursementCategory = new ReimbursementCategory();
        BeanUtils.copyProperties(modifyReimbursementCategoryRequest,reimbursementCategory);
        boolean result = reimbursementCategoryService.modify(reimbursementCategory);
        if(result){
            return Result.builder().build();
        }
        return Result.builder(ResultCode.SAVE_ERROR).build();
    }

    @ApiOperation(value = "删除报销类别", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "报销类别id", required = true, dataType = "int", paramType = "query"),
    })
    @PostMapping("remove")
    public Result remove(@NotNull Integer id){
        boolean result = reimbursementCategoryService.remove(id);
        if(result){
            return Result.builder().build();
        }
        return Result.builder(ResultCode.REMOVE_ERROR).build();
    }

    @ApiOperation(value = "获取单个报销类别",httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "报销类别id", required = true, dataType = "int", paramType = "query"),
    })
    @GetMapping("findById")
    public Result findById(@NotNull Integer id){
        return Result.builder()
                .data(reimbursementCategoryService.findById(id))
                .build();
    }

}
