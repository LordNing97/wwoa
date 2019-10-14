package com.xy.wwoa.approval.service;

import com.xy.wwoa.approval.mapper.CcMapper;
import com.xy.wwoa.approval.model.Cc;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: leisurexi
 * Date: 2019-08-30
 * Time: 23:01
 */
@Service
public class CcService {

    @Resource
    private CcMapper ccMapper;

    public boolean save(String approvalNumber, Integer approvalTypeId, String[] employeeIds) {
        List<Cc> ccs = new ArrayList<>(employeeIds.length);
        for (String employeeId : employeeIds) {
            Cc cc = new Cc();
            cc.setEmployeeId(Integer.valueOf(employeeId));
            cc.setApprovalNumber(approvalNumber);
            cc.setApprovalTypeId(approvalTypeId);
            cc.setCreateTime(LocalDateTime.now());
            cc.setStatus(0);
            ccs.add(cc);
        }
        return ccMapper.save(ccs) > 0;
    }

    public List<Cc> getByEmployeeId(Integer employeeId, Integer approvalTypeId, Integer status) {
        return ccMapper.findByEmployeeId(employeeId, approvalTypeId, status);
    }

    public boolean modifyCcStatus(String ids) {
        return ccMapper.modifyCcStatus(ids.split(",")) > 0;
    }

}
