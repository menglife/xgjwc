package com.xzit.ssm.service.impl;

import com.xzit.ssm.entity.Term;
import com.xzit.ssm.entity.TermExample;
import com.xzit.ssm.mapper.TermMapper;
import com.xzit.ssm.service.TermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * create by hjx on 2018/11/5 0005
 */

@Service(value = "termService")
public class TermServiceImpl implements TermService {
    //注入Mapper接口对象
    @Autowired
    private TermMapper termMapper;
    @Override
    public List<Term> findAllTerms() {
        TermExample example = new TermExample();
        TermExample.Criteria criteria = example.createCriteria();
        criteria.andTermidIsNotNull();

        return null;
    }
}
