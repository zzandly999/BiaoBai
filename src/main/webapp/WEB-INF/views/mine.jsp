<%--
  Created by IntelliJ IDEA.
  User: 86130
  Date: 2022/3/17
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>我的主页</title>
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
        a{
            color: cornflowerblue;
        }
    </style>
</head>
<body>
<c:if test="${sessionScope.if_login_success != 'success'}">
    点击<a href="/login">登录</a>以使用完整的功能
</c:if>
<c:if test="${sessionScope.if_login_success == 'success'}">
<%--    导航栏--%>
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
                                <li><a href="/iSee">我看过谁</a></li>
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
                                    <input type="text" class="form-control" placeholder="搜索商品/帖子、等">
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
        <%--轮播图--%>
        <div class="row">
            <div class="col-md-12">
                <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                    <!-- Indicators -->
                    <ol class="carousel-indicators">
                        <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                        <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                        <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                    </ol>

                    <!-- Wrapper for slides -->
                    <div class="carousel-inner" role="listbox">
                        <div class="item active">
                            <img src="/images/kh.jpg" alt="...">
                            <div class="carousel-caption">

                            </div>
                        </div>
                        <div class="item">
                            <img src="/images/qb.jpg" alt="...">
                            <div class="carousel-caption">

                            </div>
                        </div>
                        <div class="item">
                            <img src="/images/pz.jpg" alt="...">
                            <div class="carousel-caption">

                            </div>
                        </div>

                    </div>

                    <!-- Controls -->
                    <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div>
            </div>
        </div>
        <%--分页展示动态数据--%>
        <div class="row" id="comments_body">
            <c:forEach items="${sessionScope.comments.listIterator()}" var="comments" begin="0" end="${sessionScope.comments.size()}">
                <div class="col-sm-6 col-md-4">
                    <div class="thumbnail">
                        <img src="${comments.cover}" alt="...">
                        <div class="caption">
                            <h3>${comments.type}</h3>
                            <p>${comments.comment}</p>
                            <p><a href="${comments.url}" class="btn btn-primary" role="button">详情</a> <a href="" class="btn btn-default" role="button">分享</a></p>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>


    </div>
</c:if>

<script type="text/javascript">

    //1、页面加载完成以后，直接去发送ajax请求,要到分页数据
    $(function (){
        //去首页
        to_page(1);
    });

    function to_page(pn){
        $.get(
            "comments",
            "pn="+pn,
            function (data){
                console.log(data);
            }
        )
    }

    //分享
    function toShare() {
        alert("复制此 "+"http://localhost:8080/loseThing"+" 链接以分享");
    }


</script>

</body>
</html>
