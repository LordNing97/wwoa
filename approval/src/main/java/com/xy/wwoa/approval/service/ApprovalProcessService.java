package com.xy.wwoa.approval.service;

import com.xy.wwoa.approval.mapper.ApprovalProcessMapper;
import com.xy.wwoa.approval.model.ApprovalProcess;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: leisurexi
 * Date: 2019-08-27
 * Time: 23:07
 */
@Service
public class ApprovalProcessService {

    @Resource
    private ApprovalProcessMapper approvalProcessMapper;

    /**
     * 保存审批流程信息
     */
    @Transactional
    public void save(Integer employeeId, String approvalNumber, String approverIdsStr, Integer approvalTypeId) {
        if (StringUtils.isEmpty(approverIdsStr)) {
            return;
        }
        String[] approverIds = approverIdsStr.split(",");
        List<ApprovalProcess> approvalProcesses = new ArrayList<>(approverIds.length);
        for (int i = 0; i < approverIds.length; i++) {
            ApprovalProcess approvalProcess = new ApprovalProcess();
            approvalProcess.setSponsorId(employeeId);
            approvalProcess.setApprovalNumber(approvalNumber);
            approvalProcess.setApproverId(Integer.valueOf(approverIds[i]));
            approvalProcess.setApprovalTypeId(approvalTypeId);
            approvalProcess.setStatus(0);
            if (i == 0) {
                approvalProcess.setLatest(1);
            } else {
                approvalProcess.setLatest(0);
            }
            approvalProcesses.add(approvalProcess);
        }
        approvalProcessMapper.save(approvalProcesses);
    }

    public ApprovalProcess getLast(String approvalNumber) {
        return approvalProcessMapper.findLatest(approvalNumber);
    }

}
