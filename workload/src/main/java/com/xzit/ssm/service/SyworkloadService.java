package com.xzit.ssm.service;

import com.github.pagehelper.PageInfo;
import com.xzit.ssm.entity.Curworkload;
import com.xzit.ssm.entity.Syworkload;
import com.xzit.ssm.entity.SyworkloadExample;
import com.xzit.ssm.vo.SyworkloadVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * create by hjx on 2018/11/27 0027
 */
public interface SyworkloadService {
    /**
     * 按学期（xq）、课程号（kch）、课序号（kxh）批量删除
     * 参数@Param List
     */
    int deleteBatchByTermAndKchAndKxh(List<Syworkload> swls);

    /*批量添加*/
    public int insertBatch(List<Syworkload> list);
    /**
     *
     * @param termid  学期
     * @param departid  学院
     * @return
     */
    public List<Syworkload> findCurworkloads(int termid, int departid);

    /*按学院id和学期id查询,返回SyworkloadVO对象*/
    public List<SyworkloadVO> findSyworkloadsByTermidAndCollegeId(int termid, int collid);
    //分页查询数据
    public PageInfo<SyworkloadVO> findSyworkloadsByPage(
            Integer pageNo, Integer pageSize,
            int termid, int collid);

    public PageInfo<SyworkloadVO> findSyworkloadsByPage(
            Integer pageNo, Integer pageSize,
            int termid, int collid,String kch,String kxh);
    //实践工作量统计：除导入的分批次实验工作量之外，还需要统计单批次实验工作量情况
    //查询哪些课程是单批次实验但是没有通过Excel导入的课程信息
    public List<Curworkload> findCurworkloadWithExpNoImport();
    //删除全部数据
    public int deleteAll();
    //实验工作量统计结果（按xq,kch,kxh汇总后的结果，返回类型为Curworkload类型）
    public List<Curworkload> sygzltotal();
    Syworkload selectByPrimaryKey(int syid);
    int updateByExample(Syworkload record,SyworkloadExample example);
    int deleteByPrimaryKey(int id);
}
