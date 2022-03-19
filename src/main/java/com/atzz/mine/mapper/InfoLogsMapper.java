package com.atzz.mine.mapper;

import com.atzz.mine.bean.InfoLogs;
import com.atzz.mine.bean.InfoLogsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InfoLogsMapper {
    long countByExample(InfoLogsExample example);

    int deleteByExample(InfoLogsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(InfoLogs record);

    int insertSelective(InfoLogs record);

    List<InfoLogs> selectByExample(InfoLogsExample example);

    InfoLogs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") InfoLogs record, @Param("example") InfoLogsExample example);

    int updateByExample(@Param("record") InfoLogs record, @Param("example") InfoLogsExample example);

    int updateByPrimaryKeySelective(InfoLogs record);

    int updateByPrimaryKey(InfoLogs record);
}