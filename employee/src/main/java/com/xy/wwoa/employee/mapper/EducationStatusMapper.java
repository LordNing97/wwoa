package com.xy.wwoa.employee.mapper;

import com.xy.wwoa.employee.model.EducationStatus;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author 陈璇
 * @Description EducationStatusMapper
 * @date 2019/8/30 17:08
 */
@Mapper
public interface EducationStatusMapper {

    int save(EducationStatus educationStatus);

    List<EducationStatus> findByIds(String[] ids);

}
