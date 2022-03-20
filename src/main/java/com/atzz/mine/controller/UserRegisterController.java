package com.atzz.mine.controller;

import com.atzz.mine.bean.Msg;
import com.atzz.mine.bean.UserRegister;
import com.atzz.mine.service.UserRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shkstart
 * @create 2022-03-17 15:21
 */
@Controller
public class UserRegisterController {

    @Autowired
    UserRegisterService userRegisterService;
    @Autowired
    HttpSession session;

    /**
     * 去我的主页
     * @return
     */
    @RequestMapping("/mine")
    public String toIndex(){
        return "mine";
    }
    @RequestMapping("/whoSeeMe")
    public String toWhoSeeMe(){
        return "whoSeeMe";
    }
    @RequestMapping("/mySend")
    public String toMySend(){
        return "mySend";
    }
    @RequestMapping("/blackFan")
    public String toBlackFan(){
        return "blackFan";
    }
    @RequestMapping("/bodySet")
    public String toBodySet(){
        return "bodySet";
    }
    @RequestMapping("/bugFan")
    public String toBugFan(){
        return "bugFan";
    }
    @RequestMapping("/elseFan")
    public String toElseFan(){
        return "elseFan";
    }
    @RequestMapping("/friend")
    public String toFriend(){
        return "friend";
    }
    @RequestMapping("/hasName")
    public String toHasName(){
        return "hasName";
    }
    @RequestMapping("/onlineLove")
    public String toOnlineLove(){
        return "onlineLove";
    }
    @RequestMapping("/yellowFan")
    public String toYellowFan(){
        return "yellowFan";
    }

    /**
     * 去登录
     * @return
     */
    @RequestMapping("/login")
    public String toLogin(){
        return "login";
    }

    /**
     * 去注册
     * @return
     */
    @RequestMapping("/register")
    public String toRegister(){
        return "register";
    }

    /**
     * 检查登录是否成功
     * @param nickName
     * @param password
     * @return
     */
    @RequestMapping(value = "/checkLogin", method = {RequestMethod.POST})
    @ResponseBody
    public List<UserRegister> checkLogin(String nickName, String password){
        List<UserRegister> userRegisters = userRegisterService.checkLogin(nickName, password);
        if(userRegisters != null){
            session.setAttribute("if_login_success","success");
        }
        return userRegisters;
    }

    /**
     * 数据库校验用户名是否可用
     * @param nickName
     * @return
     */
    @RequestMapping(value = "/checkNickname", method = {RequestMethod.POST})
    @ResponseBody
    public Msg checkNickname(String nickName){
        //正则表达式检验用户名是否合法
        String regx = "(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})";
        if(!nickName.matches(regx)){
            return Msg.fail().add("fail_msg","用户名必须是6-16位数字和字母的组合或2-5位中文");
        }
        //数据库校验用户名是否重复
        boolean isAvailable = userRegisterService.checkRegisterNickname(nickName);
        if(isAvailable){
            return Msg.success();
        }else{
            return Msg.fail().add("fail_msg","用户名不可用");
        }
    }

    /**
     * 保存用户数据
     * @param userRegister
     * @param result
     * @return
     */
    @RequestMapping(value = "/saveUserRegister", method = {RequestMethod.POST})
    @ResponseBody
    public Msg saveUserRegister(@Valid UserRegister userRegister, BindingResult result){
        if(result.hasErrors()){
            Map<String, Object> map = new HashMap<>();
            List<FieldError> errors = result.getFieldErrors();
            for (FieldError fieldError : errors) {
                System.out.println("错误的字段名："+fieldError.getField());
                System.out.println("错误信息："+fieldError.getDefaultMessage());
                map.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return Msg.fail().add("errorFields", map);
        }else{
            userRegisterService.saveUserRegister(userRegister);
            return Msg.success();
        }
    }



}
