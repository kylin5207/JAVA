<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: shangmengqi
  Date: 2020/5/27
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>JSTL的使用——if标签</title>
</head>
<body>
    <%--
    c:if标签：
        1. 属性：test为必须属性，接受boolean表达式.
                              如果表达式为true，则显示if标签体内容，如果为false，则不显示标签体内容
                              一般情况下，test属性会结合el表达式一起使用
      注意：c:if没有else
    --%>
    <c:if test="true">
        <h1>我是帅琦</h1>
    </c:if>
    <br>

    <%
        // 判断request域中的list集合是否为控，如果不为null则遍历集合
        List list = new ArrayList<String>();
        list.add("hahaha");
        request.setAttribute("list", list);
        request.setAttribute("number", 3);

    %>

    <c:if test="${not empty list }">hahaha</c:if>   <br>
    <c:if test="${number%2 != 0}">
        ${number}为奇数
    </c:if>
</body>
</html>
