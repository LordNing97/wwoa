package com.xy.wwoa.approval.api;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @Author leisurexi
 * @Description
 * @Date 2019/9/5
 * @Time 16:45
 */
@Data
@ToString
@Builder
public class ContractApprovalList {

    private List<ContractApprovalModel> list;
    private int page;
    private long total;

}
