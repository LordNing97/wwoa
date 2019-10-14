package com.xy.wwoa.employee.service;

import com.xy.wwoa.employee.mapper.JobResumeMapper;
import com.xy.wwoa.employee.model.JobResume;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * @Author leisurexi
 * @Description
 * @Date 2019/9/9
 * @Time 11:21
 */
@Service
public class JobResumeService {

    @Resource
    private JobResumeMapper jobResumeMapper;

    public boolean save(JobResume jobResume) {
        return jobResumeMapper.save(jobResume) > 0;
    }

    public List<JobResume> getByIds(String ids) {
        return StringUtils.isEmpty(ids) ? Collections.emptyList() : jobResumeMapper.findByIds(ids.split(","));
    }

}
