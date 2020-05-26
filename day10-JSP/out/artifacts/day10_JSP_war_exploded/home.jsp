<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="top.jsp"%>
<html>
<head>
    <title>主界面</title>

</head>
<body>
    <h1>主界面</h1>

    <!--html注释：只能注释html代码-->
    <%--jsp注释：可以注释所有--%>

    <%--pageContext内置对象的使用范围只限于当前页面，而且可以获取其他8个内置对象--%>
    <%
        pageContext.setAttribute("msg", "Hello");
    %>
    <%=pageContext.getAttribute("msg")%>
</body>
</html>
