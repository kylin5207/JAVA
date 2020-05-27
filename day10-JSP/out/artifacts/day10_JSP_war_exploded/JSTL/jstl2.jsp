<%--
  Created by IntelliJ IDEA.
  User: shangmengqi
  Date: 2020/5/27
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>JSTL的使用——choose标签</title>
</head>
<body>
    <%--
        数字编号对应星期几案例
            1. 域中存储——数字
            2. 使用choose标签取出数字
            3. 使用when标签做数字判断，相当于case
            4. otherwise标签用于处理其他情况，类似于default
    --%>
    <%
        request.setAttribute("number", 3);
    %>

    <c:choose>
        <c:when test="${number == 1}">星期一</c:when>
        <c:when test="${number == 2}">星期二</c:when>
        <c:when test="${number == 3}">星期三</c:when>
        <c:when test="${number == 4}">星期四</c:when>
        <c:when test="${number == 5}">星期五</c:when>
        <c:when test="${number == 6}">星期六</c:when>
        <c:when test="${number == 7}">星期日</c:when>

        <c:otherwise>数字输入有误</c:otherwise>
    </c:choose>

</body>
</html>
