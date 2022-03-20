<%--
  Created by IntelliJ IDEA.
  User: 86130
  Date: 2022/3/20
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>状态发布</title>
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

    <div class="container-fluid">
<%--        供用户使用的模板--%>
        <div class="row-fluid">
            <div class="span12">
                <blockquote>
                    <p>
                        模板在这里
                    </p> <small>关键词 <cite>模板</cite></small>
                </blockquote>
                <div class="accordion" id="accordion-608717">
                    <div class="accordion-group">
                        <div class="accordion-heading">
                            <a class="accordion-toggle" data-parent="#accordion-608717" data-toggle="collapse" href="#accordion-element-203038">失物招领</a>
                        </div>
                        <div class="accordion-body in collapse" id="accordion-element-203038">
                            <div class="accordion-inner">
                                本人在xx大学xxx地点丢失了xxx东西<br>
                                具体时间：xx年xx月xx日上午/下午xx点<br>
                                本人联系方式：xxxxxxxxxxx（微信同）qq：xxxxxxxxxx<br>
                                描述：xxx
                            </div>
                        </div>
                    </div>
                    <div class="accordion-group">
                        <div class="accordion-heading">
                            <a class="accordion-toggle" data-parent="#accordion-608717" data-toggle="collapse" href="#accordion-element-272463">表白</a>
                        </div>
                        <div class="accordion-body collapse" id="accordion-element-272463">
                            <div class="accordion-inner">
                                表白xxx学院xxx同学<br>
                                表达你的爱意吧~~~
                            </div>
                        </div>
                    </div>
                    <div class="accordion-group">
                        <div class="accordion-heading">
                            <a class="accordion-toggle" data-parent="#accordion-608717" data-toggle="collapse" href="#accordion-element-272464">话题讨论</a>
                        </div>
                        <div class="accordion-body collapse" id="accordion-element-272464">
                            <div class="accordion-inner">
                                xx话题：此处是你要输入的文本
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <form id="sendComments_form">
                <%--    用户使用的文本输入框（对应数据库中的comment列）--%>
                <div class="row">
                    <div class="col-md-12">
                        <textarea type="text" class="form-control" rows="9" placeholder="在这里输入想要说的话"
                         name="comment" value="" id="text"></textarea>
                    </div>
                </div>
                <%--    用户选择上传的图片（对应数据库中的cover列）--%>
                <div class="row">
                    <div class="col-md-12">
                        <input type="file" id="exampleInputFile" name="cover" value="" id="cover">
                        <p class="help-block">选择要发表的图片</p>
                    </div>
                </div>
                <%--    用户选择发布的类型（对应数据库中的type列）--%>
                <div class="row">
                    <div class="col-md-12">
                        选择发布的类型：
                        <select class="form-control" name="type">
                            <option value="请选择">---请选择---</option>
                            <option value="失物招领">失物招领</option>
                            <option value="表白">表白</option>
                            <option value="话题讨论">话题讨论</option>
                        </select>
                    </div>
                </div>
                <%--        发布按钮--%>
                <div class="row">
                    <div class="col-md-5 col-md-offset-5">
                        <button class="btn btn-default btn-info" type="button" onclick="send()">发表</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

<script type="text/javascript">
    function send() {
        $.post(
            "sendComment",
            $("#sendComments_form").serialize(),
            function (data) {
                console.log(data.code);
                if(data.code == 100){
                    window.location.href = "/mine";
                }else if(data.code === 200){
                    alert("请检查发布的内容或发布的类型是否正确~~~");
                }
            }
        )
    }


</script>

</body>
</html>
