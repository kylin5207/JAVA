<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登陆时间——Cookie案例升级版</title>
</head>
<body>

    <%
        // 1. 获取所有Cookie
        boolean flag = false; // 是否找到目标cookie标记
        Cookie[] cookies = request.getCookies();

        // 2. 遍历Cookie数组
        if(cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if("lastTime".equals(name)) {
                    // 证明有该Cookie，表示不是第一次访问

                    // 1. 获取cookie对应的value值
                    String value = cookie.getValue();
                    // 解码，目前是utf-8编码的数据
                    System.out.println("解码前的数据：" + value);
                    value = URLDecoder.decode(value, "utf-8");
                    System.out.println("解码后的数据：" + value);

                    // 2. 设置新时间
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    String newvalue = sdf.format(date);
                    System.out.println("时间编码前的数据：" + newvalue);

                    //对新value值进行URL编码
                    newvalue = URLEncoder.encode(newvalue, "utf-8");
                    System.out.println("编码后的数据：" + newvalue);

                    // 3. 设置新cookie
                    cookie.setValue(newvalue);
                    response.addCookie(cookie);
                    // 4. 设置Cookie存活时间
                    cookie.setMaxAge(60*60*24*30);
    %>

                    <h1>欢迎回来，您上次访问时间为:<%=value%><h1>

    <%
                    flag = true;
                    break;
                }
            }
        }

        if(cookies == null || cookies.length == 0 || flag == false) {
            // 1. 获取时间
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            String value = sdf.format(date);

            // 2. 对时间数据进行编码处理，不然会报错
            System.out.println("时间编码前的数据：" + value);
            value = URLEncoder.encode(value, "utf-8");
            System.out.println("编码后的数据：" + value);

            // 3. 设置cookie数据
            Cookie cookie = new Cookie("lastTime", value);

            cookie.setMaxAge(60*60*24*30);
            response.addCookie(cookie);
            %>

        <h1>您好，欢迎您首次访问<%=value%>><h1>
            <%
        }

    %>

</body>
</html>
