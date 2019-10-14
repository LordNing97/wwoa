package com.xy.wwoa.setting.api;

import com.xy.wwoa.setting.model.IncreasedTaxRate;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

/**
 * @Author 陈璇
 * @Description IncreasedTaxRateList
 * @date 2019/8/29 16:27
 */
@Getter
@ToString
@Builder
public class IncreasedTaxRateList {

    private List<IncreasedTaxRate> list;
    private long total;
    private int page;

}
