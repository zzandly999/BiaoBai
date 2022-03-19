package com.atzz.mine.mapper;

import com.atzz.mine.bean.Teachers;
import com.atzz.mine.bean.TeachersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TeachersMapper {
    long countByExample(TeachersExample example);

    int deleteByExample(TeachersExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Teachers record);

    int insertSelective(Teachers record);

    List<Teachers> selectByExample(TeachersExample example);

    Teachers selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Teachers record, @Param("example") TeachersExample example);

    int updateByExample(@Param("record") Teachers record, @Param("example") TeachersExample example);

    int updateByPrimaryKeySelective(Teachers record);

    int updateByPrimaryKey(Teachers record);
}