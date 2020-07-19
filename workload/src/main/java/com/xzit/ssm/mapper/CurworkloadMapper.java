package com.xzit.ssm.mapper;

import com.xzit.ssm.entity.Curworkload;
import com.xzit.ssm.entity.CurworkloadExample;
import java.util.List;

import com.xzit.ssm.vo.GzlVO;
import com.xzit.ssm.vo.TermGzlVo;
import org.apache.ibatis.annotations.Param;

public interface CurworkloadMapper {
    int countByExample(CurworkloadExample example);

    int deleteByExample(CurworkloadExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Curworkload record);


    int insertSelective(Curworkload record);

//    List<Curworkload> selectByExample(CurworkloadExample example);

    Curworkload selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Curworkload record, @Param("example") CurworkloadExample example);

    int updateByExample(@Param("record") Curworkload record, @Param("example") CurworkloadExample example);
    int updateByExample2(@Param("record") Curworkload record, @Param("example") CurworkloadExample example);

    int updateByPrimaryKeySelective(Curworkload record);
    int updatacwd(Curworkload curworkload);
    int updateByPrimaryKey(Curworkload record);

    /*批量添加*/
    public int insertBatch(List<Curworkload> list);

    /*批量更新*/
    public int updateBatch(List<Curworkload> list);

    /*通过学期、课序号、课程号查找课程信息*/
    public Curworkload selectByUniqueKey(@Param("xq")int xq,@Param("kch")String kch,@Param("kxh")String kxh);

    /*批量更新实验工作量*/
    public int updateBatchSJgzl(List<Curworkload> list);

    //工作量统计-按部门所有学期的统计
    public List<GzlVO> gzltotalByCollege();

    //工作量统计-某部门分学期统计工作量
    public List<TermGzlVo> termgzltotalByCollege(int collid);

    //两学期工作量明细
    public List<Curworkload> twoTermgzldetails(int collid);
}