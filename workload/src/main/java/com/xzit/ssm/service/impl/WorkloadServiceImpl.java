package com.xzit.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzit.ssm.entity.Curworkload;
import com.xzit.ssm.entity.CurworkloadExample;
import com.xzit.ssm.mapper.CurworkloadMapper;
import com.xzit.ssm.service.WorkloadService;
import com.xzit.ssm.vo.GzlVO;
import com.xzit.ssm.vo.TermGzlVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * create by hjx on 2018/11/16 0016
 */

@Service(value = "workloadService")
public class WorkloadServiceImpl implements WorkloadService {

    @Autowired
    private CurworkloadMapper curworkloadMapper;

    @Override
    public Curworkload find(int xq, String kxh, String kch) {
        CurworkloadExample example = new CurworkloadExample();
        CurworkloadExample.Criteria criteria = example.createCriteria();
        criteria.andXqEqualTo(xq);
        criteria.andKxhEqualTo(kxh);
        criteria.andKchEqualTo(kch);
        List<Curworkload> list =null;
        if(list==null||list.size()==0)  return null;
        return list.get(0);
    }

    @Override
    public int insertBatch(List<Curworkload> list) {
        return curworkloadMapper.insertBatch(list);
    }

    @Override
    public int updateBatch(List<Curworkload> list) {
        return curworkloadMapper.updateBatch(list);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return curworkloadMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateCourse(Curworkload record) {
        return curworkloadMapper.updateByPrimaryKeySelective(record);
    }



    @Override
    public int updataWorkload(Curworkload record){
        System.out.println(record.getId());
        return  curworkloadMapper.updateByPrimaryKey(record);
    }

    @Override
    public int updateByExample(Curworkload record, CurworkloadExample example) {

        return curworkloadMapper.updateByExample2(record,example);
    }

    @Override
    public int updatacwd(Curworkload record) {
        return curworkloadMapper.updatacwd(record);
    }

    //分页查询数据
    public PageInfo<Curworkload> findCurworkloadsByPage(
            Integer pageNo, Integer pageSize,
            int termid, int departid, String coursetype){
        pageNo = pageNo == null?1:pageNo;
        pageSize = pageSize == null?10:pageSize;
        PageHelper.startPage(pageNo, pageSize);
        List<Curworkload> curworkloadList = findCurworkloads(termid,departid,coursetype);
        PageInfo<Curworkload> pageInfo = new PageInfo<>(curworkloadList);
        return  pageInfo;
    }

    public PageInfo<Curworkload> findCurworkloadsByPage(
            Integer pageNo, Integer pageSize,
            int termid, int departid, String coursetype,String kcm,String skls){
        pageNo = pageNo == null?1:pageNo;
        pageSize = pageSize == null?10:pageSize;
        PageHelper.startPage(pageNo, pageSize);
        List<Curworkload> curworkloadList = findCurworkloads(termid,departid,coursetype,kcm,skls);
        PageInfo<Curworkload> pageInfo = new PageInfo<>(curworkloadList);
        return  pageInfo;
    }

    public List<Curworkload> findCurworkloads(int termid, int departid, String coursetype){
        CurworkloadExample example = new CurworkloadExample();
        CurworkloadExample.Criteria criteria = example.createCriteria();
        if(termid>0){
            criteria.andXqEqualTo(termid);
        }
        if(departid>0){
            criteria.andYxidEqualTo(departid);
        }
        if(coursetype!=null && !"".equals(coursetype.trim())){
            criteria.andBzEqualTo(coursetype);
        }
        return null;
    }

    public List<Curworkload> findCurworkloads(int termid, int departid, String coursetype,String kcm,String skls){
        CurworkloadExample example = new CurworkloadExample();
        CurworkloadExample.Criteria criteria = example.createCriteria();
        if(termid>0){
            criteria.andXqEqualTo(termid);
        }
        if(departid>0){
            criteria.andYxidEqualTo(departid);
        }
        if(coursetype!=null && !"".equals(coursetype.trim())){
            criteria.andBzEqualTo(coursetype);
        }

        if(kcm!=null && !"".equals(kcm.trim())){
            criteria.andKcmLike("%" + kcm + "%");
        }

        if(skls!=null && !"".equals(skls)){
            criteria.andSklsLike("%" + skls + "%");
        }

        return null;
    }

    @Override
    public Curworkload selectByUniqueKey(int xq, String kch, String kxh) {
        return curworkloadMapper.selectByUniqueKey(xq,kch,kxh);
    }

    @Override
    //批量更新实验工作量和工作量总和
    public int updateBatchSJgzl(List<Curworkload> cwls){
        return curworkloadMapper.updateBatchSJgzl(cwls);
    }

    //工作量统计-按部门所有学期的统计
    @Override
    public List<GzlVO> gzltotalByCollege(){
        return curworkloadMapper.gzltotalByCollege();
    }

    //清理所有数据
    @Override
    public int deleteAll(){
        CurworkloadExample example = new CurworkloadExample();
        CurworkloadExample.Criteria criteria = example.createCriteria();
        criteria.andIdIsNotNull();
        return curworkloadMapper.deleteByExample(example);
    }

    //工作量统计-某部门分学期统计工作量
    public List<TermGzlVo> termgzltotalByCollege(int collid){
        return curworkloadMapper.termgzltotalByCollege(collid);
    }

    //两学期工作量明细
    public List<Curworkload> twoTermgzldetails(int collid){
       return curworkloadMapper.twoTermgzldetails(collid);
    }

    @Override
    public Curworkload findByPrimaryKey(Integer id) {
        return curworkloadMapper.selectByPrimaryKey(id);
    }
}
