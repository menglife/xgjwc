package com.xzit.ssm.mapper;

import com.xzit.ssm.entity.Curworkload;
import com.xzit.ssm.entity.Syworkload;
import com.xzit.ssm.entity.SyworkloadExample;
import com.xzit.ssm.vo.SyworkloadVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SyworkloadMapper {
    int countByExample(SyworkloadExample example);

    int deleteByExample(SyworkloadExample example);

    int deleteByPrimaryKey(Integer syid);

    int insert(Syworkload record);

    int insertSelective(Syworkload record);

    List<Syworkload> selectByExample(SyworkloadExample example);

    Syworkload selectByPrimaryKey(Integer syid);

    int updateByExampleSelective(@Param("record") Syworkload record, @Param("example") SyworkloadExample example);

    int updateByExample(@Param("record") Syworkload record, @Param("example") SyworkloadExample example);

    int updateByPrimaryKeySelective(Syworkload record);

    int updateByPrimaryKey(Syworkload record);

    /**
     * 按学期（xq）、课程号（kch）、课序号（kxh）批量删除
     * 参数@Param List
     */
    int deleteBatchByTermAndKchAndKxh(List<Syworkload> swls);

    /*批量添加*/
    public int insertBatch(List<Syworkload> list);

    /*按学院id和学期id查询*/
    List<SyworkloadVO> selectByTermidAndCollegeId(@Param("termid") int termid, @Param("collid") int collid);
    List<SyworkloadVO> selectByTermidAndCollegeIdAndKchAndKxh(@Param("termid") int termid,
                                                              @Param("collid") int collid,
                                                              @Param("kch") String kch,
                                                              @Param("kxh") String kxh);
    //查询没有导入到syworkload表中的带有实验课程信息
    List<Curworkload> findCurworkloadWithExpNoImport();

    //实验工作量统计结果（按xq,kch,kxh汇总后的结果，返回类型为Curworkload类型）
    List<Curworkload> sygzltotal();



}