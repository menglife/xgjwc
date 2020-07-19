package com.xzit.ssm.mapper;

import com.xzit.ssm.entity.Totalworkload;
import com.xzit.ssm.entity.TotalworkloadExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TotalworkloadMapper {
    int countByExample(TotalworkloadExample example);

    int deleteByExample(TotalworkloadExample example);

    int deleteByPrimaryKey(Integer gzlid);

    int insert(Totalworkload record);

    int insertSelective(Totalworkload record);

    List<Totalworkload> selectByExample(TotalworkloadExample example);

    Totalworkload selectByPrimaryKey(Integer gzlid);

    int updateByExampleSelective(@Param("record") Totalworkload record, @Param("example") TotalworkloadExample example);

    int updateByExample(@Param("record") Totalworkload record, @Param("example") TotalworkloadExample example);

    int updateByPrimaryKeySelective(Totalworkload record);

    int updateByPrimaryKey(Totalworkload record);
}