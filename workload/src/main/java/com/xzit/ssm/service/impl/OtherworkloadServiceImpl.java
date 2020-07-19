package com.xzit.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzit.ssm.entity.Otherworkload;
import com.xzit.ssm.entity.OtherworkloadExample;
import com.xzit.ssm.mapper.OtherworkloadMapper;
import com.xzit.ssm.service.OtherworkloadService;
import com.xzit.ssm.vo.OtherworkloadVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * create by hjx on 2018/11/28 0028
 */
@Service(value = "otherworkloadService")
public class OtherworkloadServiceImpl implements OtherworkloadService {
    @Autowired
    private OtherworkloadMapper otherworkloadMapper;

    @Override
    public Otherworkload findById(int otherid) {
        return otherworkloadMapper.selectByPrimaryKey(otherid);
    }

    @Override
    public List<OtherworkloadVO> findByTermidAndCollid(int xq, int collid) {
        return otherworkloadMapper.findByTermidAndCollid(xq,collid);
    }

    @Override
    public PageInfo<OtherworkloadVO> findPageByTermidAndCollid(Integer pageNo, Integer pageSize, int xq, int collid) {
        pageNo = pageNo == null?1:pageNo;
        pageSize = pageSize == null?10:pageSize;
        PageHelper.startPage(pageNo, pageSize);
        List<OtherworkloadVO> otherworkloadVOList = findByTermidAndCollid(xq,collid);
        PageInfo<OtherworkloadVO> pageInfo = new PageInfo<>(otherworkloadVOList);
        return  pageInfo;
    }

    @Override
    public int insert(Otherworkload otherworkload) {
        return otherworkloadMapper.insertSelective(otherworkload);
    }

    @Override
    public int update(Otherworkload otherworkload) {
        return otherworkloadMapper.updateByPrimaryKeySelective(otherworkload);
    }

    @Override
    public int deleteById(int otherid) {
        return otherworkloadMapper.deleteByPrimaryKey(otherid);
    }

    @Override
    public int deleteAll() {
        OtherworkloadExample example = new OtherworkloadExample();
        OtherworkloadExample.Criteria criteria = example.createCriteria();
        criteria.andOtheridIsNotNull();
        return otherworkloadMapper.deleteByExample(example);
    }
}
