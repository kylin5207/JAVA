<%--
  Created by IntelliJ IDEA.
  User: shangmengqi
  Date: 2020/5/22
  Time: 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>500</title>
    <style>
        .middle{
            margin:0px auto;
            padding: 0px;
            align-content: center;
            text-align: center;
            width: max-content;
        }
    </style>
</head>
<body class="middle">
    <img src="pic/500.jpg" alt="服务器错误" width="800" height="500">
    <%
        String message = exception.getMessage();
        System.out.println(message);
    %>
</body>
</html>
