package com.atzz.mine.mapper;

import com.atzz.mine.bean.UserRealnames;
import com.atzz.mine.bean.UserRealnamesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserRealnamesMapper {
    long countByExample(UserRealnamesExample example);

    int deleteByExample(UserRealnamesExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserRealnames record);

    int insertSelective(UserRealnames record);

    List<UserRealnames> selectByExampleWithBLOBs(UserRealnamesExample example);

    List<UserRealnames> selectByExample(UserRealnamesExample example);

    UserRealnames selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserRealnames record, @Param("example") UserRealnamesExample example);

    int updateByExampleWithBLOBs(@Param("record") UserRealnames record, @Param("example") UserRealnamesExample example);

    int updateByExample(@Param("record") UserRealnames record, @Param("example") UserRealnamesExample example);

    int updateByPrimaryKeySelective(UserRealnames record);

    int updateByPrimaryKeyWithBLOBs(UserRealnames record);

    int updateByPrimaryKey(UserRealnames record);
}