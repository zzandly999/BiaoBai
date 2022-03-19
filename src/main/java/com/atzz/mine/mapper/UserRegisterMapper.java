package com.atzz.mine.mapper;

import com.atzz.mine.bean.UserRegister;
import com.atzz.mine.bean.UserRegisterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserRegisterMapper {
    long countByExample(UserRegisterExample example);

    int deleteByExample(UserRegisterExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserRegister record);

    int insertSelective(UserRegister record);

    List<UserRegister> selectByExample(UserRegisterExample example);

    UserRegister selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserRegister record, @Param("example") UserRegisterExample example);

    int updateByExample(@Param("record") UserRegister record, @Param("example") UserRegisterExample example);

    int updateByPrimaryKeySelective(UserRegister record);

    int updateByPrimaryKey(UserRegister record);
}