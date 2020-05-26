<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>success</title>
</head>
<body>
    <div id="head">
        <h1>
            <%=request.getSession().getAttribute("username")%>，欢迎您来到帅琦庄园摸鱼～
        </h1>
    </div>

    <div id="center">
        <img src="pictures/welcome.jpeg" alt="欢迎" width="640" height="960">
    </div>



</body>
</html>
