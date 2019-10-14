package com.xy.wwoa.approval.api;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Author leisurexi
 * @Description
 * @Date 2019/9/5
 * @Time 16:36
 */
@Data
@ToString
@Builder
public class ContractApprovalModel {

    private String approvalNumber;
    private String organizationName;
    private String contractNumber;
    private String contractTypeName;
    private LocalDateTime signingTime;
    private BigDecimal contractMoney;
    private String ourSideCompanyName;
    private String salesPrincipal;
    private String otherSideCompanyName;
    private String customerContact;

}
