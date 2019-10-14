package com.xy.wwoa.approval.strategy;

import com.xy.wwoa.approval.api.ApprovalDetail;
import com.xy.wwoa.approval.api.ApprovalModel;
import com.xy.wwoa.approval.model.ApprovalProcess;
import com.xy.wwoa.approval.model.ContractApproval;
import com.xy.wwoa.approval.service.ApprovalProcessService;
import com.xy.wwoa.approval.service.ContractApprovalService;
import com.xy.wwoa.approval.util.ApprovalUtil;
import com.xy.wwoa.common.config.FileConfig;
import com.xy.wwoa.common.util.CommonUtil;
import com.xy.wwoa.common.util.DateUtil;
import com.xy.wwoa.common.util.SpringBeanUtil;
import com.xy.wwoa.setting.service.ContractTermsService;

/**
 * @Author leisurexi
 * @Description
 * @Date 2019/9/5
 * @Time 17:59
 */
public class ContractApprovalStrategy implements ApprovalStrategy {

    private ContractApprovalService contractApprovalService = SpringBeanUtil.getBean(ContractApprovalService.class);
    private ApprovalProcessService approvalProcessService = SpringBeanUtil.getBean(ApprovalProcessService.class);
    private ContractTermsService contractTermsService = SpringBeanUtil.getBean(ContractTermsService.class);
    private FileConfig fileConfig = SpringBeanUtil.getBean(FileConfig.class);

    @Override
    public ApprovalModel buildApprovalModel(String approvalNumber, Integer approvalTypeId) {
        ContractApproval contractApproval = contractApprovalService.getByApprovalNumber(approvalNumber);
        ApprovalProcess last = approvalProcessService.getLast(approvalNumber);
        ApprovalModel approvalModel = ApprovalModel.builder()
                .approvalNumber(contractApproval.getApprovalNumber())
                .approvalTypeId(approvalTypeId)
                .approverId(last.getApproverId())
                .createUserName(contractApproval.getCreateUserName())
                .title(contractApproval.getCreateUserName() + "提交的合同续签")
                .subTitle1("合同编号: " + contractApproval.getContractNumber())
                .subTitle2("签约日期: " + DateUtil.convertDateToString(contractApproval.getSigningTime()))
                .subTitle3("我方单位名称: " + contractApproval.getOurSideCompanyName())
                .createUser(contractApproval.getCreateUser())
                .createTime(contractApproval.getCreateTime())
                .status(last.getStatus())
                .state(ApprovalUtil.approvalStatusStr(last.getStatus(), last.getApproverName()))
                .build();
        return approvalModel;
    }

    @Override
    public ApprovalDetail buildApprovalDetail(String approvalNumber, Integer approvalTypeId) {
        ContractApproval contractApproval = contractApprovalService.getByApprovalNumber(approvalNumber);
        contractApproval.setContractTerms(contractTermsService.getByIds(contractApproval.getContractTermsIds()));
        String[] imgs = CommonUtil.splitCommaForGetArray(contractApproval.getImgs());
        String imgPaths = "";
        for (String img : imgs) {
            imgPaths += fileConfig.getImgUrlPrefix() + img + ",";
        }
        contractApproval.setImgs(CommonUtil.removeEndMark(imgPaths));
        String[] annexs = CommonUtil.splitCommaForGetArray(contractApproval.getAnnexs());
        String annexPaths = "";
        for (String annex : annexs) {
            annexPaths += fileConfig.getFileUrlPrefix() + annex + ",";
        }
        contractApproval.setAnnexs(CommonUtil.removeEndMark(annexPaths));
        ApprovalDetail approvalDetail = ApprovalDetail.builder()
                .createUser(contractApproval.getCreateUser())
                .createUserName(contractApproval.getCreateUserName())
                .createTime(contractApproval.getCreateTime())
                .ccIds(contractApproval.getCcIds())
                .approvalContent(contractApproval)
                .build();
        return approvalDetail;
    }

    @Override
    public void approved(String approvalNumber) {

    }

}
