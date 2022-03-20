package com.atzz.mine.service;

import com.atzz.mine.bean.DynamicInformations;
import com.atzz.mine.bean.DynamicInformationsExample;
import com.atzz.mine.bean.UserRegister;
import com.atzz.mine.mapper.DynamicInformationsMapper;
import com.atzz.mine.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.ListIterator;

/**
 * @author shkstart
 * @create 2022-03-18 14:22
 */
@Service
public class DynamicInformationsService {

    @Autowired
    DynamicInformationsMapper dynamicInformationsMapper;
    UserRegister userRegister;

    /**
     * 查询所有的讨论消息
     * @return
     */
    public List<DynamicInformations> getAll(){
        List<DynamicInformations> dynamicInformations = dynamicInformationsMapper.selectByExample(null);
        return dynamicInformations;
    }

    /**
     * 保存讨论信息
     * @param dynamicInformations
     * @return true：保存成功，false：保存失败
     */
    public boolean saveComments(DynamicInformations dynamicInformations){
        String url = "";
        if("失物招领".equalsIgnoreCase(dynamicInformations.getType())){
            url = "/loseThing";
        }
        if("表白".equalsIgnoreCase(dynamicInformations.getType())){
            url = "/love";
        }
        if("话题讨论".equalsIgnoreCase(dynamicInformations.getType())){
            url = "/talk";
        }
        if("请选择".equalsIgnoreCase(dynamicInformations.getType())){
            return false;
        }
        if("".equalsIgnoreCase(dynamicInformations.getComment()) || dynamicInformations.getComment() == null){
            return false;
        }
        DynamicInformations dynamicInformations1 = new DynamicInformations(null, TimeUtils.currentTime(new Date()),TimeUtils.currentTime(new Date())
        ,null,null,null,null,url,dynamicInformations.getType(),null,null,null,
                dynamicInformations.getComment(),"/images/ca.jpg", userRegister.getId());
        dynamicInformationsMapper.insertSelective(dynamicInformations1);
        return true;
    }

    /**
     * 查询发布的动态
     * @param userRegisterId
     * @return
     */
    public List<DynamicInformations> getComments(Long userRegisterId){
        DynamicInformationsExample example = new DynamicInformationsExample();
        DynamicInformationsExample.Criteria criteria = example.createCriteria();
        criteria.andUserRegisterIdEqualTo(userRegisterId);
        List<DynamicInformations> myComments = dynamicInformationsMapper.selectByExample(example);
        return myComments;
    }

    /**
     * 搜索数据
     * @param keyword
     * @return
     */
    public List<DynamicInformations> searchComments(String keyword){
        DynamicInformationsExample example = new DynamicInformationsExample();
        DynamicInformationsExample.Criteria criteria = example.createCriteria();
        criteria.andTypeLike(keyword);
        List<DynamicInformations> dynamicInformations = dynamicInformationsMapper.selectByExample(example);
        return dynamicInformations;
    }

}
