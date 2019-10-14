package com.xy.wwoa.employee.service;

import com.xy.wwoa.employee.mapper.FamilyStatusMapper;
import com.xy.wwoa.employee.model.FamilyStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * @Author leisurexi
 * @Description
 * @Date 2019/9/9
 * @Time 11:20
 */
@Service
public class FamilyStatusService {

    @Resource
    private FamilyStatusMapper familyStatusMapper;

    public boolean save(FamilyStatus familyStatus) {
        return familyStatusMapper.save(familyStatus) > 0;
    }

    public List<FamilyStatus> getByIds(String ids) {
        return StringUtils.isEmpty(ids) ? Collections.emptyList() : familyStatusMapper.findByIds(ids.split(","));
    }

}
