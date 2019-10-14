package com.xy.wwoa.approval.util;

/**
 * @Author 陈璇
 * @Description ApprovalUtil
 * @date 2019/9/2 9:11
 */
public class ApprovalUtil {

    private ApprovalUtil() {
    }

    public static String approvalStatusStr(Integer status, String employeeName) {
        String statusStr = approvalStatusStr(status);
        return status == 0 ? employeeName + statusStr : statusStr;
    }

    public static String approvalStatusStr(Integer status) {
        String state = "审批中";
        switch (status) {
            case 1:
                state = "审批通过";
                break;
            case 2:
                state = "审批拒绝";
                break;
            case 3:
                state = "已撤销";
                break;
        }
        return state;
    }

    public static String approvalDetailStatusStr(Integer status) {
        String state = "审批中";
        switch (status) {
            case 1:
                state = "已通过";
                break;
            case 2:
                state = "已拒绝";
                break;
            case 3:
                state = "已撤销";
                break;
        }
        return state;
    }

    public static String workHandoverStr(Integer workHandover) {
        String str = "";
        switch (workHandover) {
            case 0:
                str = "未完成";
                break;
            case 1:
                str = "完成";
                break;
        }
        return str;
    }

}
