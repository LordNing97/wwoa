package com.xy.wwoa.web.controller;


import com.xy.wwoa.approval.task.ApprovalTasks;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: leisurexi
 * Date: 2019-09-01
 * Time: 18:10
 */
@Controller
@Api(value = "线程状况接口", produces = "application/json")
public class WebController {

    @Resource
    private ApprovalTasks approvalTasks;

    @ApiOperation(value = "获取当前线程运行状况", httpMethod = "GET")
    @RequestMapping("allStackTraces")
    @ResponseBody
    public List<String> allStackTraces() {
        List<String> result = new ArrayList<>();
        for (Map.Entry<Thread, StackTraceElement[]> stackTrace : Thread.getAllStackTraces().entrySet()) {
            Thread thread = stackTrace.getKey();
            StackTraceElement[] stackTraceValue = stackTrace.getValue();
            if (thread.equals(Thread.currentThread())) {
                continue;
            }
            for (StackTraceElement stackTraceElement : stackTraceValue) {
                result.add("线程: " + thread.getName() + ", stack: " + stackTraceElement);
            }
        }
        return result;
    }

    @RequestMapping("sendTurnPositiveMessage")
    @ResponseBody
    public void sendTurnPositiveMessage() {
        approvalTasks.turnPositiveRemind();
    }

    @RequestMapping("sendContactRenewMessage")
    @ResponseBody
    public void sendContactRenewMessage() {
        approvalTasks.contractRenewRemind();
    }

}
