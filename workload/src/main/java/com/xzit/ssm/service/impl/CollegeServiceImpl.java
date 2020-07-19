package com.xzit.ssm.service.impl;

import com.xzit.ssm.entity.College;
import com.xzit.ssm.entity.CollegeExample;
import com.xzit.ssm.mapper.CollegeMapper;
import com.xzit.ssm.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * create by hjx on 2018/11/5 0005
 */
@Service(value = "collegeService")
public class CollegeServiceImpl implements CollegeService {
    @Autowired
    private CollegeMapper collegeMapper;
    @Override
    public List<College> findAll() {
        CollegeExample example = new CollegeExample();
        CollegeExample.Criteria criteria = example.createCriteria();
        criteria.andCollidIsNotNull();
        return null;
    }

    @Override
    public College findByCollid(int collid){
        return collegeMapper.selectByPrimaryKey(collid);
    }
}
