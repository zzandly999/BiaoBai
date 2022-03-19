package com.atzz.mine.controller;

import com.atzz.mine.bean.DynamicInformations;
import com.atzz.mine.bean.Msg;
import com.atzz.mine.service.DynamicInformationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 评论
 * @author shkstart
 * @create 2022-03-18 14:22
 */
@Controller
public class DynamicInformationsController {

    @Autowired
    DynamicInformationsService dynamicInformationsService;
    @Autowired
    HttpSession session;

    /**
     * 去失物招领页面
     * @return
     */
    @RequestMapping("/loseThing")
    public String toLoseThing(){ return "topic/loseThing"; }

    /**
     * 去告白页面
     * @return
     */
    @RequestMapping("/love")
    public String toLove(){ return "topic/love"; }

    /**
     * 去话题讨论页面
     * @return
     */
    @RequestMapping("/talk")
    public String toTalk(){ return "topic/talk"; }

    /**
     * 获取分页信息
     * @param
     * @return
     */
    @RequestMapping("/comments")
    @ResponseBody
    public Msg getPagInfo(){
        List<DynamicInformations> dynamicInformationsList = dynamicInformationsService.getAll();
        session.setAttribute("comments",dynamicInformationsList);
        return Msg.success();
    }

}
