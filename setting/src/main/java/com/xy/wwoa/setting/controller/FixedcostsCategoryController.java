package com.xy.wwoa.setting.controller;

import com.xy.wwoa.common.api.PageResult;
import com.xy.wwoa.common.api.Result;
import com.xy.wwoa.common.api.ResultCode;
import com.xy.wwoa.common.util.PageUtil;
import com.xy.wwoa.setting.api.FixedcostsCategoryList;
import com.xy.wwoa.setting.model.FixedcostsCategory;
import com.xy.wwoa.setting.request.ModifyFixedcostsCategoryRequest;
import com.xy.wwoa.setting.request.SaveFixedcostsCategoryRequest;
import com.xy.wwoa.setting.service.FixedcostsCategoryService;
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
 * @Description FixedcostsCategoryController
 * @date 2019/8/29 8:53
 */
@RestController
@RequestMapping("fixedcostsCategory")
@Validated
@Api(value = "固定费用类别接口", produces = "application/json")
public class FixedcostsCategoryController {

    @Resource
    private FixedcostsCategoryService fixedcostsCategoryService;

    @ApiOperation(value = "保存固定费用类别",httpMethod = "POST")
    @PostMapping("save")
    public Result save(@ModelAttribute @Valid SaveFixedcostsCategoryRequest saveFixedcostsCategoryRequest){
        FixedcostsCategory fixedcostsCategory = new FixedcostsCategory();
        BeanUtils.copyProperties(saveFixedcostsCategoryRequest,fixedcostsCategory);
        boolean result = fixedcostsCategoryService.save(fixedcostsCategory);
        if(result){
            return Result.builder().build();
        }
        return Result.builder(ResultCode.SAVE_ERROR).build();
    }

    @ApiOperation(value = "编辑固定费用类别", httpMethod = "POST")
    @PostMapping("modify")
    public Result modify(@ModelAttribute @Valid ModifyFixedcostsCategoryRequest modifyFixedcostsCategoryRequest){
        FixedcostsCategory fixedcostsCategory = new FixedcostsCategory();
        BeanUtils.copyProperties(modifyFixedcostsCategoryRequest,fixedcostsCategory);
        boolean result = fixedcostsCategoryService.modify(fixedcostsCategory);
        if(result){
            return Result.builder().build();
        }
        return Result.builder(ResultCode.SAVE_ERROR).build();
    }

    @ApiOperation(value = "删除固定费用类别", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "固定费用类别id", required = true, dataType = "int", paramType = "query")
    })
    @PostMapping("delete")
    public Result delete(@NotNull Integer id){
        boolean result = fixedcostsCategoryService.delete(id);
        if(result){
            return Result.builder().build();
        }
        return Result.builder(ResultCode.REMOVE_ERROR).build();
    }

    @ApiOperation(value = "分页查询固定费用类别", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "category", value = "固定费用类别内容",dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "status", value = "状态",dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "page", value = "当前页",dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "size", value = "每页显示的数量",dataType = "int", paramType = "query")
    })
    @GetMapping("listFixedcostsCategory")
    public PageResult listFixedcostsCategory(String category, Integer status, Integer page, Integer size){
        FixedcostsCategoryList fixedcostsCategoryList = fixedcostsCategoryService.listFixedcostsCategory(category, status , page == null ? PageUtil.PAGE_DEFAULT : page, size == null ? PageUtil.SIZE_DEFAULT : size);
        return PageResult.<FixedcostsCategory>builder()
                .data(fixedcostsCategoryList.getList())
                .page(fixedcostsCategoryList.getPage())
                .total(fixedcostsCategoryList.getTotal())
                .build();
    }

    @ApiOperation(value = "根据ID获取固定费用类别", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "int", paramType = "query")
    })
    @GetMapping("selectById")
    public Result selectById(Integer id){
        return Result.builder()
                .data(fixedcostsCategoryService.selectById(id))
                .build();
    }

}
