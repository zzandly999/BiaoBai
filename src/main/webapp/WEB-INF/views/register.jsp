<%--
  Created by IntelliJ IDEA.
  User: 86130
  Date: 2022/3/15
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>注册页面</title>
    <%
        pageContext.setAttribute("APP_PATH",request.getContextPath());
    %>
    <script type="text/javascript"
            src="${APP_PATH}/static/js/jquery-1.12.4.min.js"></script>
    <link
            href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
            rel="stylesheet">
    <script
            src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <style type="text/css">
        body{
            background-color: wheat;
        }
    </style>
</head>
<body>
<%--注册表单--%>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <h1 align="center">欢迎注册</h1>
        </div>
    </div>
    <form class="form-horizontal" id="register_form">
        <div class="row">
            <div class="form-group">
                用户名<input type="text" class="form-control" placeholder="请输入用户名" value="" id="register_username"
                          onchange="check_username_register()" name="nickName">
                <span class="help-block"></span>
            </div>
        </div>
        <div class="row">
            <div class="form-group">
                密码<input type="password" class="form-control" placeholder="请输入密码" value="" id="register_password"
                         onchange="check_password_register()" name="password">
                <span class="help-block"></span>
            </div>
        </div>
        <div class="row">
            <div class="form-group">
                邮箱<input type="email" class="form-control" placeholder="请输入邮箱" value="" id="register_email"
                         onchange="check_email_register()" name="email">
                <span class="help-block"></span>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-xs-11">
                邮箱验证码<input type="text" class="form-control" placeholder="请输入邮箱验证码" value="123456" id="register_emailAuthentication"
                          name="emailAuthentication">
                <span class="help-block"></span>
            </div>
        </div>
        <div class="row">
            <div class="form-group">
                电话<input type="tel" class="form-control" placeholder="请输入电话号码" value="" id="register_mobile"
                         onchange="check_mobile_register()" name="mobile">
                <span class="help-block"></span>
            </div>
        </div>
        <div class="row">
            <div class="form-group">
                学号<input type="text" class="form-control" placeholder="请输入9位学号" value="" id="register_studentNumber"
                         onchange="check_studentNumber_register()" name="studentNumber">
                <span class="help-block"></span>
            </div>
        </div>
        <div>
            <input class="btn btn-default" type="button" value="注册" id="register_btn" onclick="register()">
        </div>
    </form>

</div>



<script type="text/javascript">

    //注册功能
    function register() {
        //检查之前的表单是否填入正确
        if(!check_register_form()){
            return false;
        };
        //判断用户名是否可用
        if($(this).attr("username_if_available") == "fail"){
            return false;
        }
        $.post(
            "saveUserRegister",
            $("#register_form").serialize(),
            function (data) {
                if(data.code == 100){
                    window.location.href = "/login";
                }else{
                    //显示失败信息
                    //console.log(result);
                    //有哪个字段的错误信息就显示哪个字段的；
                    if(undefined != data.extend.errorFields.email){
                        //显示邮箱错误信息
                        check_result("#register_email", "error", data.extend.errorFields.email);
                    }
                    if(undefined != data.extend.errorFields.nickName){
                        //显示员工名字的错误信息
                        check_result("#register_username", "error", data.extend.errorFields.nickName);
                    }
                    if(undefined != data.extend.errorFields.password){
                        //显示员工名字的错误信息
                        check_result("#register_password", "error", data.extend.errorFields.password);
                    }
                }
            }
        )
    }
    //检验学号
    function check_studentNumber_register() {
        var studentNumber = $("#register_studentNumber").val();
        var regStudentNumber = /^\d{9}$/;
        if(!regStudentNumber.test(studentNumber)){
            check_result("#register_studentNumber","fail","学号输入错误");
            return false;
        }else{
            check_result("#register_studentNumber","success","");
        }
        return true;
    }
    //校验电话号码
    function check_mobile_register() {
        var mobile = $("#register_mobile").val();
        var regMobile = /^1\d{10}$/;
        if(!regMobile.test(mobile)){
            check_result("#register_mobile","fail","不是完整的11位手机号");
            return false;
        }else{
            check_result("#register_mobile","success","");
        }
        return true;
    }
    //检验用户名
    function check_username_register() {
        var username = $("#register_username").val();
        var regName = /(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})/;
        //检验用户名是否合法
        if(!regName.test(username)){
            check_result("#register_username","fail","用户名可以是2-5位中文或者6-16位英文和数字的组合");
            return false;
        }else{
            $.post(
                "checkNickname",
                "nickName="+username,
                function (data) {
                    if(data.code == 200){
                        check_result("#register_username","fail",data.extend.fail_msg);
                        $("#register_btn").attr("username_if_available","fail");
                        return false;
                    }else{
                        check_result("#register_username","success","");
                        $("#register_btn").attr("username_if_available","success");
                    }
                }
            )
        }
        return true;
    }
    //校验密码
    function check_password_register() {
        var password = $("#register_password").val();
        var regPassword = /^(\w){6,20}$/;
        //校验密码
        if(!regPassword.test(password)){
            check_result("#register_password","fail","密码不合法");
            return false;
        }else{
            check_result("#register_password","success","");
        }
        return true;
    }
    //校验邮箱
    function check_email_register() {
        var email = $("#register_email").val();
        var regEmail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
        //校验邮箱
        if(!regEmail.test(email)){
            check_result("#register_email","fail","邮箱格式不合法");
            return false;
        }else{
            check_result("#register_email","success","");
        }
        return true;
    }
    //前端检测表单中的数据是否合法
    function check_register_form() {
        var username = $("#register_username").val();
        var regName = /(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})/;
        var email = $("#register_email").val();
        var regEmail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
        var password = $("#register_password").val();
        var regPassword = /^(\w){6,20}$/;
        var mobile = $("#register_mobile").val();
        var regMobile = /^1\d{10}$/;
        var studentNumber = $("#register_studentNumber").val();
        var regStudentNumber = /^\d{9}$/;

        //检验用户名
        if(!regName.test(username)){
            check_result("#register_username","fail","用户名可以是2-5位中文或者6-16位英文和数字的组合");
            return false;
        }else{
            check_result("#register_username","success","");
        }
        //校验密码
        if(!regPassword.test(password)){
            check_result("#register_password","fail","密码不合法");
            return false;
        }else{
            check_result("#register_password","success","");
        }
        //校验邮箱
        if(!regEmail.test(email)){
            check_result("#register_email","fail","邮箱格式不合法");
            return false;
        }else{
            check_result("#register_email","success","");
        }
        if(!regMobile.test(mobile)){
            check_result("#register_mobile","fail","不是完整的11位手机号");
            return false;
        }else{
            check_result("#register_mobile","success","");
        }
        if(!regStudentNumber.test(studentNumber)){
            check_result("#register_studentNumber","fail","学号输入错误");
            return false;
        }else{
            check_result("#register_studentNumber","success","");
        }
        return true;
    }


    //显示检验结果的提示信息
    //btn：id
    //status；状态（success，fail）
    //msg：回显的消息
    function check_result(id, status, msg) {
        //清除提示信息（以防下次登录时边框带颜色）
        $(id).parent().removeClass("has-success has-error");
        //以防回显错误的提示信息
        $(id).next("span").text("");
        if("success" == status){
            $(id).parent().addClass("has-success");
            $(id).next("span").text(msg);
        }else if("fail" == status){
            $(id).parent().addClass("has-error");
            $(id).next("span").text(msg);
        }
    }
</script>
</body>
</html>
