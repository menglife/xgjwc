package com.ssmshiro.dao;

import com.ssmshiro.entity.Otherworkload;
import com.ssmshiro.entity.OtherworkloadExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OtherworkloadMapper {
    long countByExample(OtherworkloadExample example);

    int deleteByExample(OtherworkloadExample example);

    int deleteByPrimaryKey(Integer otherid);

    int insert(Otherworkload record);

    int insertSelective(Otherworkload record);

    List<Otherworkload> selectByExample(OtherworkloadExample example);

    Otherworkload selectByPrimaryKey(Integer otherid);

    int updateByExampleSelective(@Param("record") Otherworkload record, @Param("example") OtherworkloadExample example);

    int updateByExample(@Param("record") Otherworkload record, @Param("example") OtherworkloadExample example);

    int updateByPrimaryKeySelective(Otherworkload record);

    int updateByPrimaryKey(Otherworkload record);
}