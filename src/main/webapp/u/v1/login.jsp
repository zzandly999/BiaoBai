<%--
  Created by IntelliJ IDEA.
  User: 86130
  Date: 2022/3/15
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>登录页面</title>
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
            background-color: #fff;
        }
        a {
            color: red;
        }
    </style>
</head>
<body>

<div class="container">
    <%--        标题--%>
    <div class="row">
        <div class="col-md-12" align="center">
            <h1>欢迎登录</h1>
            <%--        注册--%>
            <div align="center">
                如果没有账号请<a href="/register">注册</a>
            </div>
        </div>
    </div>
    <%--        用户名输入框--%>
    <div class="row">
        <div class="col-md-offset-3" align="right">
            <label for="inputEmail3" class="col-sm-2 control-label">用户名</label>
            <div class="col-sm-4">
                <input type="text" class="form-control" id="inputEmail3" placeholder="Username"
                       value="">
                <span class="help-block"></span>
            </div>
        </div>
    </div>
    <%--        密码输入框--%>
    <div class="row">
        <div class="col-md-offset-3" align="right">
            <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
            <div class="col-sm-4">
                <input type="password" class="form-control" id="inputPassword3" placeholder="Password"
                       value="">
                <span class="help-block"></span>
            </div>
        </div>
    </div>
    <%--记住我--%>
    <div>
        <div class="col-md-offset-3">
            <div class="col-sm-offset-2 col-sm-10">
                <div class="checkbox">
                    <label>
                        <input type="checkbox"> Remember me
                    </label>
                </div>
            </div>
        </div>
    </div>
    <%--        登录按钮--%>
    <div>
        <div class="col-md-offset-3">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default" onclick="login()">登录</button>
            </div>
        </div>
    </div>
    <div class="col-md-offset-3">
        <span id="span_password"></span>
    </div>

</div>



<script type="text/javascript">
    //处理登录业务
    function login() {
        var nickname = $("#inputEmail3").val();
        var password = $("#inputPassword3").val();
        $.post(
            "checkLogin",
            "nickName="+nickname+"&password="+password,
            function (data) {
                if(data != ""){
                    location.href="/mine";
                }else{
                    $("#span_password").html('<font color="red">账户名或密码错误！</font>');
                }
            }
        )
    }
</script>

</body>
</html>
