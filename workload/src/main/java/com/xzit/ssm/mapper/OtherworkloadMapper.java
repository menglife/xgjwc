package com.xzit.ssm.mapper;

import com.xzit.ssm.entity.Otherworkload;
import com.xzit.ssm.entity.OtherworkloadExample;
import com.xzit.ssm.vo.OtherworkloadVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OtherworkloadMapper {
    int countByExample(OtherworkloadExample example);

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

    List<OtherworkloadVO> findByTermidAndCollid(@Param("termid") int termid, @Param("collid") int collid);

}