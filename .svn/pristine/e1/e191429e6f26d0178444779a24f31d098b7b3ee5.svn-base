package com.xy.wwoa.approval.strategy;

/**
 * @Author leisurexi
 * @Description
 * @Date 2019/8/31
 * @Time 11:59
 */
public class ApprovalFactory {

    public ApprovalStrategy buildApprovalModel(Integer approvalTypeId) {
        ApprovalStrategy approvalStrategy = null;
        switch (approvalTypeId){
            case 1:
            case 2:
                approvalStrategy = new EntryApprovalStrategy();
                break;
            case 3:
                approvalStrategy = new BecomeWorkerStrategy();
                break;
            case 4:
                approvalStrategy = new RenewApprovalStrategy();
                break;
            case 5:
                approvalStrategy = new LeaveApprovalStrategy();
                break;
            case 6:
                approvalStrategy = new PerformanceAppraisalStrategy();
                break;
            case 7:
                approvalStrategy = new WorkSummaryStrategy();
                break;
            case 8:
                approvalStrategy = new InterchangeableApprovalStrategy();
                break;
            case 9:
                approvalStrategy = new ContractApprovalStrategy();
                break;
        }
        return approvalStrategy;
    }

    private ApprovalFactory() {
    }

    public static ApprovalFactory getInstance() {
        return ApprovalFactoryInstance.INSTANCE;
    }

    private static class ApprovalFactoryInstance {
        private static ApprovalFactory INSTANCE = new ApprovalFactory();
    }

}
