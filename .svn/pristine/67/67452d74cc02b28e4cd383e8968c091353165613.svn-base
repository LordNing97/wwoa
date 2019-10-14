package com.xy.wwoa.employee.service;

import com.xy.wwoa.employee.mapper.EducationStatusMapper;
import com.xy.wwoa.employee.model.EducationStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * @Author leisurexi
 * @Description
 * @Date 2019/9/9
 * @Time 11:19
 */
@Service
public class EducationStatusService {

    @Resource
    private EducationStatusMapper educationStatusMapper;

    public boolean save(EducationStatus educationStatus) {
        return educationStatusMapper.save(educationStatus) > 0;
    }

    public List<EducationStatus> getByIds(String ids) {
        return StringUtils.isEmpty(ids) ? Collections.emptyList() : educationStatusMapper.findByIds(ids.split(","));
    }

}
