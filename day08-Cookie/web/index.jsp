<%--
  Created by IntelliJ IDEA.
  User: shangmengqi
  Date: 2020/5/4
  Time: 21:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>


  <%
    System.out.println("Hello, jsp");
    String contextPath = request.getContextPath();
    out.write(contextPath);
  %>

  </body>
</html>
