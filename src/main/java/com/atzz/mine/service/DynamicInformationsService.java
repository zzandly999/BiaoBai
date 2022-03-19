package com.atzz.mine.service;

import com.atzz.mine.bean.DynamicInformations;
import com.atzz.mine.mapper.DynamicInformationsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shkstart
 * @create 2022-03-18 14:22
 */
@Service
public class DynamicInformationsService {

    @Autowired
    DynamicInformationsMapper dynamicInformationsMapper;

    /**
     * 查询所有的讨论消息
     * @return
     */
    public List<DynamicInformations> getAll(){
        List<DynamicInformations> dynamicInformations = dynamicInformationsMapper.selectByExample(null);
        return dynamicInformations;
    }

}
