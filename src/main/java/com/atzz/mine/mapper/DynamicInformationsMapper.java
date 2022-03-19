package com.atzz.mine.mapper;

import com.atzz.mine.bean.DynamicInformations;
import com.atzz.mine.bean.DynamicInformationsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DynamicInformationsMapper {
    long countByExample(DynamicInformationsExample example);

    int deleteByExample(DynamicInformationsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DynamicInformations record);

    int insertSelective(DynamicInformations record);

    List<DynamicInformations> selectByExample(DynamicInformationsExample example);

    DynamicInformations selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DynamicInformations record, @Param("example") DynamicInformationsExample example);

    int updateByExample(@Param("record") DynamicInformations record, @Param("example") DynamicInformationsExample example);

    int updateByPrimaryKeySelective(DynamicInformations record);

    int updateByPrimaryKey(DynamicInformations record);
}