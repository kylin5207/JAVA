<%--
  Created by IntelliJ IDEA.
  User: shangmengqi
  Date: 2020/5/22
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el表达式学习1——算术运算符测试</title>
</head>
<body>
    <h1>算数运算符</h1>
    3 + 2 = ${3 + 2} <br>
    <h1>比较运算符</h1>
    3 > 4 ? ${3 > 4} <br>
    <h1>逻辑运算符</h1>
    3 > 4 and 3 < 2 ? ${3 > 4 and 3 < 2}
    3 > 4 && 3 < 2 ? ${3 > 4 && 3 < 2}

    <h1>empty运算符</h1>
    <%
        String str1 = "abc";
        request.setAttribute("str1", str1);
        String str2 = "";
        request.setAttribute("str2", str2);
    %>

    empty "abc" = ${empty str1}<br>
    not empty "abc" = ${not empty str1}<br>
    empty "" = ${empty str2}
</body>
</html>
