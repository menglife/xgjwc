package com.xzit.ssm.service;

import com.github.pagehelper.PageInfo;
import com.xzit.ssm.entity.Curworkload;
import com.xzit.ssm.entity.CurworkloadExample;
import com.xzit.ssm.vo.GzlVO;
import com.xzit.ssm.vo.TermGzlVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * create by hjx on 2018/11/16 0016
 */
public interface WorkloadService {

    /*根据学期，课程号、课序号查询*/
    public Curworkload find(int xq,String kxh,String kch);

    /*批量添加*/
    public int insertBatch(List<Curworkload> list);

    /*批量更新*/
    public int updateBatch(List<Curworkload> list);
    int deleteByPrimaryKey(Integer id);
   //单条更新
   int updateCourse(Curworkload record);
   int updataWorkload(Curworkload record);
    int updateByExample(Curworkload record,CurworkloadExample example);
    int updatacwd(Curworkload record);

    //分页查询数据
    public PageInfo<Curworkload> findCurworkloadsByPage(
            Integer pageNo, Integer pageSize,
            int termid, int departid, String coursetype);

    public PageInfo<Curworkload> findCurworkloadsByPage(
            Integer pageNo, Integer pageSize,
            int termid, int departid, String coursetype,String kcm,String skls);


    public List<Curworkload> findCurworkloads(int termid, int departid, String coursetype);

    /*通过学期、课序号、课程号查找课程信息*/
    public Curworkload selectByUniqueKey(int xq,String kch,String kxh);

    //批量更新实验工作量和工作量总和
    public int updateBatchSJgzl(List<Curworkload> cwls);

    //工作量统计-按部门所有学期的统计
    public List<GzlVO> gzltotalByCollege();

    //清理所有数据
    public int deleteAll();

    //工作量统计-某部门分学期统计工作量
    public List<TermGzlVo> termgzltotalByCollege(int collid);

    //两学期工作量明细
    public List<Curworkload> twoTermgzldetails(int collid);
    //根据指定id查找
    Curworkload findByPrimaryKey(Integer id);

}
