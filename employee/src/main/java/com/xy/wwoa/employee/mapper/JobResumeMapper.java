package com.xy.wwoa.employee.mapper;

import com.xy.wwoa.employee.model.JobResume;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * @Author leisurexi
 * @Description
 * @Date 2019/8/30
 * @Time 17:42
 */
@Mapper
public interface JobResumeMapper {

    int save(JobResume jobResume);

    List<JobResume> findByIds(String[] ids);

}
