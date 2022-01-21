<%--
  Created by IntelliJ IDEA.
  User: mechrevo
  Date: 2022-01-20
  Time: 21:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <script>
        window.onload = function () {
            document.getElementById("img").onclick = function () {
                this.src = "/first_web_proj/verify?time=" + new Date().getTime();
            }
        }

    </script>
    <style>
        p {
            color: red;
        }
    </style>
</head>
<body>
<form action="/first_web_proj/check_login" method="post">
    <table>
        <tr>
            <td>用户名</td>
            <td>
                <label>
                    <input type="text" name="username">
                </label>
            </td>
        </tr>
        <tr>
            <td>密码</td>
            <td>
                <label>
                    <input type="password" name="password">
                </label>
            </td>
        </tr>
        <tr>
            <td>验证码</td>
            <td>
                <label>
                    <input type="text" name="checkCode">
                </label>
            </td>
        </tr>
        <tr>
            <td colspan="2"><img id="img" src="/first_web_proj/verify"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="登录"></td>
        </tr>
    </table>
</form>
<div>
    <p>
        <%=
        request.getAttribute("v_error") == null ? "" : request.getAttribute("v_error")
        %>
    </p>
    <p>
        <%=
        request.getAttribute("u_error") == null ? "" : request.getAttribute("u_error")
        %>
    </p>
</div>
</body>
</html>
