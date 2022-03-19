package com.atzz.mine.service;

import com.atzz.mine.bean.UserRegister;
import com.atzz.mine.bean.UserRegisterExample;
import com.atzz.mine.mapper.UserRegisterMapper;
import com.atzz.mine.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author shkstart
 * @create 2022-03-17 15:23
 */
@Service
public class UserRegisterService {

    @Autowired
    UserRegisterMapper userRegisterMapper;

    /**
     * 数据库校验用户是否存在（根据用户名和密码）
     * @param nickname
     * @param password
     * @return null：不存在，反之则存在
     */
    public List<UserRegister> checkLogin(String nickname, String password){
        UserRegisterExample example = new UserRegisterExample();
        UserRegisterExample.Criteria criteria = example.createCriteria();
        criteria.andNickNameEqualTo(nickname).andPasswordEqualTo(password);
        List<UserRegister> userRegisters = userRegisterMapper.selectByExample(example);
        return userRegisters;
    }

    /**
     * 数据库校验用户名是否可用
     * @param nickName
     * @return true：可用，false：不可用
     */
    public boolean checkRegisterNickname(String nickName) {
        UserRegisterExample example = new UserRegisterExample();
        UserRegisterExample.Criteria criteria = example.createCriteria();
        criteria.andNickNameEqualTo(nickName);
        long userRegisters = userRegisterMapper.countByExample(example);
        return userRegisters == 0;
    }

    /**
     * 保存用户
     * @param userRegister
     */
    public void saveUserRegister(UserRegister userRegister) {
        UserRegister userRegister1 = new UserRegister(null, TimeUtils.currentTime(new Date()),TimeUtils.currentTime(new Date())
        ,null,userRegister.getMobile(),userRegister.getNickName(),null,userRegister.getStudentNumber()
        ,userRegister.getEmail()
        ,userRegister.getPassword(),null,null,null,null
        , userRegister.getEmailAuthentication(),null,null,null);
        userRegisterMapper.insertSelective(userRegister1);
    }
}
