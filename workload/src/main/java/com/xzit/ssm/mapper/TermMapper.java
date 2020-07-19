package com.xzit.ssm.mapper;

import com.xzit.ssm.entity.Term;
import com.xzit.ssm.entity.TermExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TermMapper {
    int countByExample(TermExample example);

    int deleteByExample(TermExample example);

    int deleteByPrimaryKey(Integer termid);

    int insert(Term record);

    int insertSelective(Term record);

//    List<Term> selectByExample(TermExample example);

    Term selectByPrimaryKey(Integer termid);

    int updateByExampleSelective(@Param("record") Term record, @Param("example") TermExample example);

    int updateByExample(@Param("record") Term record, @Param("example") TermExample example);

    int updateByPrimaryKeySelective(Term record);
    int updataid(int id);

    int updateByPrimaryKey(Term record);
}