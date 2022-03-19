package com.atzz.mine.mapper;

import com.atzz.mine.bean.SonComments;
import com.atzz.mine.bean.SonCommentsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SonCommentsMapper {
    long countByExample(SonCommentsExample example);

    int deleteByExample(SonCommentsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SonComments record);

    int insertSelective(SonComments record);

    List<SonComments> selectByExample(SonCommentsExample example);

    SonComments selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SonComments record, @Param("example") SonCommentsExample example);

    int updateByExample(@Param("record") SonComments record, @Param("example") SonCommentsExample example);

    int updateByPrimaryKeySelective(SonComments record);

    int updateByPrimaryKey(SonComments record);
}