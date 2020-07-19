package com.xzit.ssm.service;

import com.github.pagehelper.PageInfo;
import com.xzit.ssm.entity.Otherworkload;
import com.xzit.ssm.vo.OtherworkloadVO;

import java.util.List;

/**
 * create by hjx on 2018/11/28 0028
 */
public interface OtherworkloadService {
    //按otherid查询
    public Otherworkload findById(int otherid);
    //按学院和学期查询
    public List<OtherworkloadVO> findByTermidAndCollid(int xq,int collid);
    //按学院和学期查询
    public PageInfo<OtherworkloadVO> findPageByTermidAndCollid(Integer pageNo, Integer pageSize,int xq,int collid);
    //添加记录
    public int insert(Otherworkload otherworkload);
    //修改
    public int update(Otherworkload otherworkload);
    //根据id删除
    public int deleteById(int otherid);
    //清空所有数据
    public int deleteAll();

}
