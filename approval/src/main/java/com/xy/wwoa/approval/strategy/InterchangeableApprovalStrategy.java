package com.xy.wwoa.approval.strategy;

import com.xy.wwoa.approval.api.ApprovalDetail;
import com.xy.wwoa.approval.api.ApprovalModel;
import com.xy.wwoa.approval.model.ApprovalProcess;
import com.xy.wwoa.approval.model.InterchangeableApproval;
import com.xy.wwoa.approval.service.ApprovalProcessService;
import com.xy.wwoa.approval.service.InterchangeableApprovalService;
import com.xy.wwoa.approval.util.ApprovalUtil;
import com.xy.wwoa.common.config.FileConfig;
import com.xy.wwoa.common.util.CommonUtil;
import com.xy.wwoa.common.util.SpringBeanUtil;
import com.xy.wwoa.employee.mapper.ProvinceMapper;
import org.springframework.util.StringUtils;


/**
 * @Author leisurexi
 * @Description
 * @Date 2019/8/31
 * @Time 16:47
 */
public class InterchangeableApprovalStrategy implements ApprovalStrategy {

    private ProvinceMapper provinceMapper = SpringBeanUtil.getBean(ProvinceMapper.class);
    private InterchangeableApprovalService interchangeableApprovalService = SpringBeanUtil.getBean(InterchangeableApprovalService.class);
    private ApprovalProcessService approvalProcessService = SpringBeanUtil.getBean(ApprovalProcessService.class);
    private FileConfig fileConfig = SpringBeanUtil.getBean(FileConfig.class);

    @Override
    public ApprovalModel buildApprovalModel(String approvalNumber, Integer approvalTypeId) {
        InterchangeableApproval interchangeableApproval = interchangeableApprovalService.getByApprovalNumber(approvalNumber);
        ApprovalProcess last = approvalProcessService.getLast(approvalNumber);
        ApprovalModel approvalModel = ApprovalModel.builder()
                .approvalNumber(interchangeableApproval.getApprovalNumber())
                .approvalTypeId(approvalTypeId)
                .approverId(last.getApproverId())
                .createUserName(interchangeableApproval.getCreateUserName())
                .title(interchangeableApproval.getCreateUserName() + "提交的通用审批")
                .subTitle1("申请内容: " + interchangeableApproval.getApplyContent())
                .subTitle2("审批详情: " + interchangeableApproval.getApprovalDetail())
                .createUser(interchangeableApproval.getCreateUser())
                .createTime(interchangeableApproval.getCreateTime())
                .status(last.getStatus())
                .state(ApprovalUtil.approvalStatusStr(last.getStatus(), last.getApproverName()))
                .build();
        return approvalModel;
    }

    @Override
    public ApprovalDetail buildApprovalDetail(String approvalNumber, Integer approvalTypeId) {
        InterchangeableApproval interchangeableApproval = interchangeableApprovalService.getByApprovalNumber(approvalNumber);
        String[] imgs = CommonUtil.splitCommaForGetArray(interchangeableApproval.getImgs());
        String imgPaths = "";
        for (String img : imgs) {
            imgPaths += fileConfig.getImgUrlPrefix() + img + ",";
        }
        interchangeableApproval.setImgs(CommonUtil.removeEndMark(imgPaths));
        interchangeableApproval.setJobName(provinceMapper.findById(interchangeableApproval.getJobId()).getProvinceName());
        ApprovalDetail approvalDetail = ApprovalDetail.builder()
                .createUser(interchangeableApproval.getCreateUser())
                .createUserName(interchangeableApproval.getCreateUserName())
                .createTime(interchangeableApproval.getCreateTime())
                .ccIds(interchangeableApproval.getCcIds())
                .approvalContent(interchangeableApproval)
                .build();
        return approvalDetail;
    }

    @Override
    public void approved(String approvalNumber) {

    }

}
