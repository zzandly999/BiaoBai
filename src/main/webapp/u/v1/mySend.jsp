<%--
  Created by IntelliJ IDEA.
  User: 86130
  Date: 2022/3/17
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>我的发布</title>
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
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-md-12">
            <nav class="navbar navbar-inverse">
                <div class="container-fluid">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="/mine">Your乐</a>
                    </div>
                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav">
                            <li><a href="/whoSeeMe">谁看过我</a></li>
                            <li class="active"><a href="/mySend">我的发布</a></li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">反馈 <span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="/yellowFan">黄反</a></li>
                                    <li><a href="/blackFan">黑反</a></li>
                                    <li><a href="/bodySet">页面布局</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li><a href="/bugFan">BUG反馈</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li><a href="/elseFan">其它</a></li>
                                </ul>
                            </li>
                        </ul>
                        <form class="navbar-form navbar-left">
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Search">
                            </div>
                            <button type="submit" class="btn btn-default">搜索</button>
                        </form>
                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="/onlineLove">在线表白</a></li>
                            <li><a href="/friend">邀请好友</a></li>
                            <li><a href="/hasName">实名认证</a></li>
                        </ul>
                    </div><!-- /.navbar-collapse -->
                </div><!-- /.container-fluid -->
            </nav>
        </div>
    </div>

    <%--分页展示动态数据--%>
    <div class="row" id="mySendComments_body">
        <c:forEach items="${sessionScope.mySendComments.listIterator()}" var="mySendComments" begin="0" end="${sessionScope.mySendComments.size()}">
            <div class="col-sm-6 col-md-4">
                <div class="thumbnail">
                    <img src="${mySendComments.cover}" alt="...">
                    <div class="caption">
                        <h3>${mySendComments.type}</h3>
                        <p>${mySendComments.comment}</p>
                        <p><a href="${mySendComments.url}" class="btn btn-primary" role="button" id="show_messege">详情</a> <a href="" class="btn btn-default" role="button" onclick="toShare()">分享</a></p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>

</div>

<script type="text/javascript">

    //1、页面加载完成以后，直接去发送ajax请求,要到数据
    $(function (){
        to_myPage()
    });

    function to_myPage(){
        $.get(
            "getMySendComments",
            "userRegisterId="+1,
            function (data){
                console.log(data);
                mySend(data);
            }
        )
    }


    //分享
    function toShare() {
        var href = $("#show_messege").attr('href');
        var url = "http://localhost:8080" + href;
        alert("复制此 "+url+" 链接以分享");
        $("#show_messege").removeAttr();
    }



</script>

</body>
</html>
