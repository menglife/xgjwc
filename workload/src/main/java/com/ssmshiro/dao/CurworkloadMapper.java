package com.ssmshiro.dao;

import com.ssmshiro.entity.Curworkload;
import com.ssmshiro.entity.CurworkloadExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CurworkloadMapper {
    long countByExample(CurworkloadExample example);

    int deleteByExample(CurworkloadExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Curworkload record);

    int insertSelective(Curworkload record);

    List<Curworkload> selectByExample(CurworkloadExample example);

    Curworkload selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Curworkload record, @Param("example") CurworkloadExample example);

    int updateByExample(@Param("record") Curworkload record, @Param("example") CurworkloadExample example);

    int updateByPrimaryKeySelective(Curworkload record);

    int updateByPrimaryKey(Curworkload record);
}