<%--
  Created by IntelliJ IDEA.
  User: shangmengqi
  Date: 2020/5/26
  Time: 23:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el表达式学习2——从域对象中获取值</title>
</head>
<body>
    <%--1. 在域中存储数据--%>
    <%
        request.setAttribute("name", "Kylin");
        session.setAttribute("age", "23");
        session.setAttribute("name", "ysl");
    %>

    <%--2. 使用el获取值--%>
    ${requestScope.name}<br>
    ${sessionScope.age}<br>

    name : ${name}


</body>
</html>
