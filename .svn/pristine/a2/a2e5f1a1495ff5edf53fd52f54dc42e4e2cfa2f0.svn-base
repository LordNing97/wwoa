package com.xy.wwoa.setting.service;

import com.xy.wwoa.setting.mapper.ContractTermsMapper;
import com.xy.wwoa.setting.model.ContractTerms;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * @Author leisurexi
 * @Description
 * @Date 2019/9/5
 * @Time 14:32
 */
@Service
public class ContractTermsService {

    @Resource
    private ContractTermsMapper contractTermsMapper;

    public String save(List<ContractTerms> contractTerms) {
        String ids = "";
        for (ContractTerms contractTerm : contractTerms) {
            contractTermsMapper.save(contractTerm);
            ids += contractTerm.getId() + ",";
        }
        return ids.length() > 0 ? ids.substring(0, ids.length() - 1) : ids;
    }

    public List<ContractTerms> getByIds(String ids) {
        return StringUtils.isEmpty(ids) ? Collections.emptyList() : contractTermsMapper.findByIds(ids.split(","));
    }

}
