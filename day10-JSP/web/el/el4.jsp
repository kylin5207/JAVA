<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: shangmengqi
  Date: 2020/5/27
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el表达式学习4——获取List o rmap集合</title>
</head>
<body>

    <%
        List list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);

        request.setAttribute("list", list);

        Map map = new HashMap<String, String>();
        map.put("first", "Kylin");
        map.put("second", "Ysl");
        map.put("third", "DC");

        request.setAttribute("map", map);
    %>

    <h3>el获取List值</h3>
    ${requestScope.list}<br>
    ${requestScope.list[0]}

    <h3>el获取Map值</h3>
    ${map.first}<br>
    ${map["second"]}

</body>
</html>
