<%@ page import="domain.User" %>
<%@ page import="java.util.Date" %>
<%@ page import="jdk.jfr.DataAmount" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: shangmengqi
  Date: 2020/5/27
  Time: 18:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>JSTL案例</title>
</head>
<body>
    <%--
        JSTL案例练习：
        在request域中有⼀个存有User对象的List集合。需要使用jstl+el将list集合数据展示到jsp⻚⾯的表格table中
    --%>
    <%
        User user1 = new User("Kylin", 18, new Date());
        User user2 = new User("Ysl", 40, new Date());
        User user3 = new User("BuDing", 3, new Date());

        List list = new ArrayList<User>();
        list.add(user1);
        list.add(user2);
        list.add(user3);

        request.setAttribute("list", list);
    %>
    <table border="1" width="500" align="center">
        <tr>
            <th>编号</th>
            <th>姓名</th>
            <th>年龄</th>
            <th>生日</th>
        </tr>

        <c:forEach items="${list}" var="user" varStatus="s">
            <c:if test="${s.count % 2 == 0}">
                <tr bgcolor="#ffc0cb">
                    <td>${s.count}</td>
                    <td>${user.name}</td>
                    <td>${user.age}</td>
                    <td>${user.birthdayStr}</td>
                </tr>
            </c:if>

            <c:if test="${s.count % 2 == 1}">
                <tr bgcolor="#7fffd4">
                    <td>${s.count}</td>
                    <td>${user.name}</td>
                    <td>${user.age}</td>
                    <td>${user.birthdayStr}</td>
                </tr>
            </c:if>
        </c:forEach>
    </table>
</body>
</html>
