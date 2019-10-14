package com.xy.wwoa.approval.service;

import com.xy.wwoa.approval.api.ContractApprovalList;
import com.xy.wwoa.approval.api.ContractApprovalModel;
import com.xy.wwoa.approval.mapper.ContractApprovalMapper;
import com.xy.wwoa.approval.model.ContractApproval;
import com.xy.wwoa.approval.util.ApprovalNumberDevice;
import com.xy.wwoa.setting.service.ContractTermsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author leisurexi
 * @Description
 * @Date 2019/9/5
 * @Time 14:00
 */
@Service
public class ContractApprovalService {

    @Resource
    private ContractApprovalMapper contractApprovalMapper;

    @Resource
    private ApprovalProcessService approvalProcessService;

    @Resource
    private ContractTermsService contractTermsService;

    public ContractApproval getByApprovalNumber(String approvalNumber) {
        return contractApprovalMapper.findByApprovalNumber(approvalNumber);
    }

    /**
     * 保存合同审批信息
     */
    @Transactional
    public boolean save(Integer employeeId, ContractApproval contractApproval, Integer approvalTypeId) {
        String approvalNumber = ApprovalNumberDevice.createApprovalNumber();
        contractApproval.setApprovalNumber(approvalNumber);
        contractApproval.setCreateUser(employeeId);
        contractApproval.setCreateTime(LocalDateTime.now());
        contractApproval.setStatus(0);
        //保存合同条款
        String ids = contractTermsService.save(contractApproval.getContractTerms());
        contractApproval.setContractTermsIds(ids);
        //保存审批信息
        contractApprovalMapper.save(contractApproval);
        //保存审批流程信息
        approvalProcessService.save(employeeId, approvalNumber, contractApproval.getApproverIds(), approvalTypeId);
        return true;
    }

    /**
     * 后台 项目管理-合同审批
     */
    public ContractApprovalList listContractApproval(Integer organizationId, String contractNumber, Integer contractTypeId,
                                                     LocalDateTime signingTime, String ourSideCompanyName, String otherSideCompanyName,
                                                     Integer page, Integer size) {
        List<ContractApproval> contractApprovalList = contractApprovalMapper.listContractApproval(organizationId, contractNumber, contractTypeId, signingTime, ourSideCompanyName, otherSideCompanyName, (page - 1) * size, page * size);
        long total = contractApprovalMapper.countContractApproval(organizationId, contractNumber, contractTypeId, signingTime, ourSideCompanyName, otherSideCompanyName);
        List<ContractApprovalModel> contractApprovalModels = contractApprovalList.stream().map(contractApproval -> {
            ContractApprovalModel contractApprovalModel = ContractApprovalModel.builder()
                    .approvalNumber(contractApproval.getApprovalNumber())
                    .organizationName(contractApproval.getOrganizationName())
                    .contractNumber(contractApproval.getContractNumber())
                    .contractMoney(contractApproval.getContractMoney())
                    .contractTypeName(contractApproval.getContractTypeName())
                    .signingTime(contractApproval.getSigningTime())
                    .ourSideCompanyName(contractApproval.getOurSideCompanyName())
                    .salesPrincipal(contractApproval.getSalesPrincipal())
                    .otherSideCompanyName(contractApproval.getOtherSideCompanyName())
                    .customerContact(contractApproval.getCustomerContact())
                    .customerContact(contractApproval.getCustomerContact())
                    .build();
            return contractApprovalModel;
        }).collect(Collectors.toList());
        return ContractApprovalList.builder()
                .list(contractApprovalModels)
                .page(page)
                .total(total)
                .build();
    }

}
