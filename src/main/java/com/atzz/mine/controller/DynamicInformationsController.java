package com.atzz.mine.controller;

import com.atzz.mine.bean.DynamicInformations;
import com.atzz.mine.bean.Msg;
import com.atzz.mine.bean.UserRegister;
import com.atzz.mine.mapper.UserRegisterMapper;
import com.atzz.mine.service.DynamicInformationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    @Autowired
    UserRegisterMapper userRegisterMapper;

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
     * 去发表页面
     * @return
     */
    @RequestMapping("/send")
    public String toSend(){
        return "sendArticles";
    }

    /**
     * 去搜索页面
     * @return
     */
    @RequestMapping("/toSearch")
    public String toSearch(){
        return "search";
    }

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

    /**
     * 发表状态
     * @param dynamicInformations
     * @return
     */
    @RequestMapping(value = "/sendComment", method = {RequestMethod.POST})
    @ResponseBody
    public Msg sendComments(DynamicInformations dynamicInformations){
        boolean if_success = dynamicInformationsService.saveComments(dynamicInformations);
        if(if_success){
            return Msg.success();
        }else{
            return Msg.fail();
        }
    }

    /**
     * 查找我发布过的动态
     * @param
     * @return
     */
    @RequestMapping("/getMySendComments")
    @ResponseBody
    public Msg getComments(Long userRegisterId){
        List<DynamicInformations> mySendComments = dynamicInformationsService.getComments(userRegisterId);
        session.setAttribute("mySendComments",mySendComments);
        if(mySendComments == null){
            return Msg.fail().add("null_msg","你还没有发布过动态哦~~~");
        }else{
            return Msg.success().add("mySendComments",mySendComments);
        }
    }

    /**
     * 搜索功能
     * @param keyword
     * @return
     */
    @RequestMapping("searchMsg")
    @ResponseBody
    public Msg searchMsg(String keyword){
        List<DynamicInformations> dynamicInformations = dynamicInformationsService.searchComments(keyword);
        session.setAttribute("search_result",dynamicInformations);
        if(!dynamicInformations.isEmpty()){
            return Msg.success();
        }else{
            return Msg.fail().add("fail_msg","没有找到匹配此关键字的数据");
        }
    }


}
