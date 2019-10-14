package com.xy.wwoa.approval.api;

import com.xy.wwoa.approval.model.InterchangeableApproval;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @Author 陈璇
 * @Description InterchangeableApprovalList
 * @date 2019/9/5 16:12
 */
@Data
@ToString
@Builder
public class InterchangeableApprovalList {

    private List<InterchangeableApprovalModal> list;
    private long total;
    private Integer page;

}
