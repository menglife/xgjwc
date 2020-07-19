package com.xzit.ssm.mapper;

import com.xzit.ssm.entity.College;
import com.xzit.ssm.entity.CollegeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CollegeMapper {
    int countByExample(CollegeExample example);

    int deleteByExample(CollegeExample example);

    int deleteByPrimaryKey(Integer collid);

    int insert(College record);

    int insertSelective(College record);

//    List<College> selectByExample(CollegeExample example);
    College selectCollegeById(Integer collid);

    College selectByPrimaryKey(Integer collid);

    int updateByExampleSelective(@Param("record") College record, @Param("example") CollegeExample example);

    int updateByExample(@Param("record") College record, @Param("example") CollegeExample example);

    int updateByPrimaryKeySelective(College record);

    int updateByPrimaryKey(College record);
}