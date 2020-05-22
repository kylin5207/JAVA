<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%--
  指令配置JSP页面，导入文件文件
  格式：<%@ 指令名称 属性名1=属性值1 属性名2=属性值2 ... %>
  1. page 配置JSP页面
  2. include 导入页面的资源文件
  3. taglib 导入资源

--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" errorPage="500.jsp" %>

<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

    <%
      List list = new ArrayList<Integer>();
    %>
  $END$
  </body>
</html>
