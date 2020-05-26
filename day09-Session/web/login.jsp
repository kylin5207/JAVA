<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>

    <style>
        .error{
            color:red;
        }
    </style>

    <script>
        window.onload = function () {
            document.getElementById("imgcode").onclick = function () {
                this.src = "/day09_Session/checkCodeServlet?time=" + new Date().getTime();
            }
        }
    </script>
</head>
<body>
    <form action="/day09_Session/loginServlet" method="post">
        <table>

            <tr>
                <td>
                    用户名
                </td>

                <td>
                    <input type="text" name="username" placeholder="请输入用户名">
                </td>
            </tr>

            <tr>
                <td>
                    密码
                </td>

                <td>
                    <input type="password" name="pwd" placeholder="请输入密码">
                </td>
            </tr>

            <tr>
                <td>
                    验证码
                </td>

                <td>
                    <input type="text" name="checkcode" placeholder="请输入验证码">
                </td>
            </tr>

            <tr>
                <td colspan="2">
                    <img id="imgcode" src="/day09_Session/checkCodeServlet"></img>
                </td>
            </tr>

            <tr>
                <td colspan="2">
                    <input type="submit" value="登陆">
                </td>
            </tr>

        </table>
    </form>

    <div class="error">
        <%=request.getAttribute("checkcode_error") == null? "" : request.getAttribute("checkcode_error")%>
    </div>

    <div class="error">
        <%=request.getAttribute("login_error") == null? "" : request.getAttribute("login_error")%>
    </div>
</body>
</html>
