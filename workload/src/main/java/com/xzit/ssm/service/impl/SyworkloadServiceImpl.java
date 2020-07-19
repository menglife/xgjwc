package com.xzit.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzit.ssm.entity.Curworkload;
import com.xzit.ssm.entity.Syworkload;
import com.xzit.ssm.entity.SyworkloadExample;
import com.xzit.ssm.mapper.CurworkloadMapper;
import com.xzit.ssm.mapper.SyworkloadMapper;
import com.xzit.ssm.service.SyworkloadService;
import com.xzit.ssm.vo.SyworkloadVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * create by hjx on 2018/11/27 0027
 */
@Service(value = "syworkloadService")
public class SyworkloadServiceImpl implements SyworkloadService {
    @Autowired
    private SyworkloadMapper syworkloadMapper;
    @Autowired
    private CurworkloadMapper curworkloadMapper;

    @Override
    public int deleteBatchByTermAndKchAndKxh(List<Syworkload> swls) {
        return syworkloadMapper.deleteBatchByTermAndKchAndKxh(swls);
    }

    @Override
    public int insertBatch(List<Syworkload> list) {
        return syworkloadMapper.insertBatch(list);
    }



    @Override
    public List<Syworkload> findCurworkloads(int termid, int departid) {
        SyworkloadExample example = new SyworkloadExample();
        SyworkloadExample.Criteria criteria = example.createCriteria();
        criteria.andXqEqualTo(termid);
        criteria.andXyidEqualTo(departid);
        return syworkloadMapper.selectByExample(example);
    }

    @Override
    public List<SyworkloadVO> findSyworkloadsByTermidAndCollegeId(int termid, int collid) {
        return syworkloadMapper.selectByTermidAndCollegeId(termid,collid);
    }

    @Override
    public PageInfo<SyworkloadVO> findSyworkloadsByPage(
            Integer pageNo, Integer pageSize,
            int termid, int collid) {
        pageNo = pageNo == null?1:pageNo;
        pageSize = pageSize == null?10:pageSize;
        PageHelper.startPage(pageNo, pageSize);
        List<SyworkloadVO> syworkloadVOList = syworkloadMapper.selectByTermidAndCollegeId(termid,collid);
        PageInfo<SyworkloadVO> pageInfo = new PageInfo<>(syworkloadVOList);
        return  pageInfo;
    }

    @Override
    public PageInfo<SyworkloadVO> findSyworkloadsByPage(
            Integer pageNo, Integer pageSize,
            int termid, int collid,String kch,String kxh) {
        pageNo = pageNo == null?1:pageNo;
        pageSize = pageSize == null?10:pageSize;
        PageHelper.startPage(pageNo, pageSize);
        List<SyworkloadVO> syworkloadVOList = syworkloadMapper.selectByTermidAndCollegeIdAndKchAndKxh(termid,collid,kch,kxh);
        PageInfo<SyworkloadVO> pageInfo = new PageInfo<>(syworkloadVOList);
        return  pageInfo;
    }

    //查询哪些课程是单批次实验但是没有通过Excel导入的课程信息
    @Override
    public List<Curworkload> findCurworkloadWithExpNoImport(){
         return syworkloadMapper.findCurworkloadWithExpNoImport();
    }

    //删除全部数据
    @Override
    public int deleteAll(){
        SyworkloadExample example = new SyworkloadExample();
        SyworkloadExample.Criteria criteria = example.createCriteria();
        criteria.andSyidIsNotNull();
        return syworkloadMapper.deleteByExample(example);
    }

    @Override
    public List<Curworkload> sygzltotal(){
        return syworkloadMapper.sygzltotal();
    }

    @Override
    public Syworkload selectByPrimaryKey(int syid) {
        return syworkloadMapper.selectByPrimaryKey(syid);
    }

    @Override
    public int updateByExample(Syworkload record, SyworkloadExample example) {
        return syworkloadMapper.updateByExample(record,example);
    }

    @Override
    public int deleteByPrimaryKey(int id) {
        return syworkloadMapper.deleteByPrimaryKey(id);
    }


}
