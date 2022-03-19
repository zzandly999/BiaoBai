package com.atzz.mine.mapper;

import com.atzz.mine.bean.FatherComments;
import com.atzz.mine.bean.FatherCommentsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FatherCommentsMapper {
    long countByExample(FatherCommentsExample example);

    int deleteByExample(FatherCommentsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FatherComments record);

    int insertSelective(FatherComments record);

    List<FatherComments> selectByExample(FatherCommentsExample example);

    FatherComments selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FatherComments record, @Param("example") FatherCommentsExample example);

    int updateByExample(@Param("record") FatherComments record, @Param("example") FatherCommentsExample example);

    int updateByPrimaryKeySelective(FatherComments record);

    int updateByPrimaryKey(FatherComments record);
}