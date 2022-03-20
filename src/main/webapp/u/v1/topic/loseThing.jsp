<%--
  Created by IntelliJ IDEA.
  User: 86130
  Date: 2022/3/18
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>失物招领</title>
    <%
        pageContext.setAttribute("APP_PATH",request.getContextPath());
    %>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-xs-6 col-md-3">
            <a href="#" class="thumbnail">
                <img src="/images/ca.jpg" alt="...">
            </a>
        </div>
        <p>本人在xx大学xxx地点丢失了xxx东西</p>
        <p>具体时间：xx年xx月xx日上午/下午xx点</p>
        <p>本人联系方式：xxxxxxxxxxx（微信同）qq：xxxxxxxxxx</p>
        描述：xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
        xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
        xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
        xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
        xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
        xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
    </div>
</div>
</body>
</html>
