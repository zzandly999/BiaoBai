package com.atzz.mine.mapper;

import com.atzz.mine.bean.OnlineLogs;
import com.atzz.mine.bean.OnlineLogsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OnlineLogsMapper {
    long countByExample(OnlineLogsExample example);

    int deleteByExample(OnlineLogsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OnlineLogs record);

    int insertSelective(OnlineLogs record);

    List<OnlineLogs> selectByExample(OnlineLogsExample example);

    OnlineLogs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OnlineLogs record, @Param("example") OnlineLogsExample example);

    int updateByExample(@Param("record") OnlineLogs record, @Param("example") OnlineLogsExample example);

    int updateByPrimaryKeySelective(OnlineLogs record);

    int updateByPrimaryKey(OnlineLogs record);
}