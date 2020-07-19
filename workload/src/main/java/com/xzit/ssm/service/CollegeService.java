package com.xzit.ssm.service;

import com.xzit.ssm.entity.College;

import java.util.List;

/**
 * create by hjx on 2018/11/5 0005
 */
public interface CollegeService {
    List<College> findAll();
    College findByCollid(int collid);
}
