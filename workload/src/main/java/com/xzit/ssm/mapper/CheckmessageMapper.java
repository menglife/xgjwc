package com.xzit.ssm.mapper;

import com.xzit.ssm.entity.Checkmessage;
import com.xzit.ssm.entity.CheckmessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CheckmessageMapper {
    long countByExample(CheckmessageExample example);

    int deleteByExample(CheckmessageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Checkmessage record);

    int insertSelective(Checkmessage record);

    List<Checkmessage> selectByExample(CheckmessageExample example);

    Checkmessage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Checkmessage record, @Param("example") CheckmessageExample example);

    int updateByExample(@Param("record") Checkmessage record, @Param("example") CheckmessageExample example);

    int updateByPrimaryKeySelective(Checkmessage record);

    int updateByPrimaryKey(Checkmessage record);
}