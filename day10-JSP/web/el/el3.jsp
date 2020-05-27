<%@ page import="domain.User" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: shangmengqi
  Date: 2020/5/27
  Time: 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el表达式学习3——获取对象的值</title>
</head>
<body>

    <%
        User user = new User();
        user.setName("Kylin");
        user.setAge(18);
        user.setBirthday(new Date());

        //在request域中存储一个类对象
        request.setAttribute("user", user);

    %>

    <h3>el获取对象中的值</h3>

    <h5>1. 直接使用requestScope.对象名获取到的是对象的toString输出</h5>
    ${requestScope.user}

    <h5>2. 使用requestScope.对象名.属性名，可以得到对象的响应属性值</h5>
    user.name = ${requestScope.user.name}<br>
    user.age = ${requestScope.user.age}<br>
    user.birthday_month = ${requestScope.user.birthday.month}<br>
    user.birthday = ${requestScope.user.birthdayStr}

</body>
</html>
