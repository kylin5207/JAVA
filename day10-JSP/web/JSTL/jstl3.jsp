<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: shangmengqi
  Date: 2020/5/27
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>JSTL的使用——foreach标签</title>
</head>
<body>
    <%--
        foreach标签类似于for 循环
            1. 完成重复的操作
                属性：
                  begin：开始值
                  end：结束值
                  var：临时变量
                  step：步长
                  varStatus：循环状态对象
                       index:容器中元素的索引，从0开始
                       count:循环次数，从1开始
            2. 遍历容器
                items:容器对象
                var:容器中元素的临时变量
    --%>

    <c:forEach begin="1" end="10" var="i" step="2" varStatus="s">
        ${i} ${s.index} ${s.count}<br>
    </c:forEach>
    <hr>

    <%
        List list = new ArrayList<String>();
        list.add("Zhangsan");
        list.add("Lisi");
        list.add("Wangwu");

        request.setAttribute("list", list);
    %>

    <c:forEach items="${list}" var="str" varStatus="s">
        ${s.index}
        ${s.count}
        ${str}
    </c:forEach>
</body>
</html>
