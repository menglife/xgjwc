package com.xzit.ssm.service;

import com.xzit.ssm.entity.Term;

import java.util.List;

/**
 * create by hjx on 2018/11/5 0005
 */
public interface TermService {
    //查询所有学期信息
    List<Term> findAllTerms();
}
