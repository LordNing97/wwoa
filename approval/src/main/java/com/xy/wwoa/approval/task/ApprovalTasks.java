package com.xy.wwoa.approval.task;

import com.xy.wwoa.approval.service.BecomeWorkerService;
import com.xy.wwoa.approval.service.RenewApprovalService;
import com.xy.wwoa.approval.util.ApprovalNumberDevice;
import com.xy.wwoa.employee.model.Employee;
import com.xy.wwoa.employee.service.EmployeeService;
import com.xy.wwoa.employee.util.PhotoMessage;
import com.xy.wwoa.employee.util.WechatUtil;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * @Author leisurexi
 * @Description
 * @Date 2019/9/4
 * @Time 9:50
 */
@Component
public class ApprovalTasks {

    @Resource
    private EmployeeService employeeService;

    @Resource
    private BecomeWorkerService becomeWorkerService;

    @Resource
    private RenewApprovalService renewApprovalService;

    /**
     * 转正提醒
     * 每天凌晨1点开始执行
     */
    @Scheduled(cron = "0 0 1 ? * *")
    public void turnPositiveRemind() {
        List<Employee> employeeList = employeeService.getCanTurnPositive();
        Set<Integer> organizationIds = new HashSet<>(employeeList.size());
        employeeList.stream().forEach(employee -> organizationIds.add(employee.getOrganizationId()));
        organizationIds.stream().forEach(organizationId -> {
            employeeList.stream().forEach(employee -> {
                if (employee.getOrganizationId().equals(organizationId)) {
                    List<Employee> managers = employeeService.getManagers(organizationId);
                    for (Employee manager : managers) {
                        String approvalNumber = ApprovalNumberDevice.createApprovalNumber();
                        becomeWorkerService.save(approvalNumber);
                        PhotoMessage photoMessage = PhotoMessage.builder()
                                .touser(manager.getId().toString())
                                .toparty(organizationId.toString())
                                .employeeId(employee.getId())
                                .employeeName(employee.getEmployeeName())
                                .userId(manager.getId())
                                .approvalNumber(approvalNumber)
                                .build();
                        WechatUtil.sendTurnPositiveMessage(photoMessage);
                    }
                }
            });
        });
    }

    /**
     * 合同续签提醒
     * 每天凌晨2点开始执行
     */
    @Scheduled(cron = "0 0 2 ? * *")
    public void contractRenewRemind() {
        List<Employee> employeeList = employeeService.getContractRenew();
        Set<Integer> organizationIds = new HashSet<>(employeeList.size());
        employeeList.stream().forEach(employee -> organizationIds.add(employee.getOrganizationId()));
        organizationIds.stream().forEach(organizationId -> {
            List<Employee> sendUsers = employeeService.getManagers(organizationId);
            sendUsers.addAll(employeeService.getPersonnel(organizationId));
            employeeList.stream().forEach(employee -> {
                if (employee.getOrganizationId().equals(organizationId)) {
                    for (Employee sendUser : sendUsers) {
                        String approvalNumber = ApprovalNumberDevice.createApprovalNumber();
                        renewApprovalService.save(approvalNumber);
                        PhotoMessage photoMessage = PhotoMessage.builder()
                                .touser(sendUser.getId().toString())
                                .toparty(organizationId.toString())
                                .employeeId(employee.getId())
                                .employeeName(employee.getEmployeeName())
                                .userId(sendUser.getId())
                                .approvalNumber(approvalNumber)
                                .build();
                        WechatUtil.sendContractRenewMessage(photoMessage);
                    }
                }
            });
        });
    }

    private String convertListToString(List<Employee> employees) {
        String ids = "";
        for (Employee employee : employees) {
            ids += employee.getId() + "|";
        }
        return ids.length() > 0 ? ids.substring(0, ids.length() - 1) : ids;
    }

    private String convertListToString(List<Employee> list1, List<Employee> list2) {
        list1.addAll(list2);
        String ids = "";
        for (Employee employee : list1) {
            ids += employee.getId() + "|";
        }
        return ids.length() > 0 ? ids.substring(0, ids.length() - 1) : ids;
    }

}
