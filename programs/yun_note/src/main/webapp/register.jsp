<%--
  Created by IntelliJ IDEA.
  User: mechrevo
  Date: 2022-03-07
  Time: 23:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户注册</title>
    <!-- meta data -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!--font-family-->
    <link href="https://fonts.googleapis.com/css?family=Poppins:100,200,300,400,500,600,700,800,900&amp;subset=devanagari,latin-ext"
          rel="stylesheet">

    <!-- title of site -->
    <title>Sign up</title>

    <!-- For favicon png -->
    <link rel="shortcut icon" type="image/icon" href="static/assets/logo/favicon.png"/>

    <!--font-awesome.min.css-->
    <link rel="stylesheet" href="static/assets/css/font-awesome.min.css">

    <!--animate.css-->
    <link rel="stylesheet" href="static/assets/css/animate.css">

    <!--bootstrap.min.css-->
    <link rel="stylesheet" href="static/bootstrap/css/bootstrap.min.css">

    <!-- bootsnav -->
    <link rel="stylesheet" href="static/assets/css/bootsnav.css">

    <!--style.css-->
    <link rel="stylesheet" href="static/assets/css/style.css">

    <!--responsive.css-->
    <link rel="stylesheet" href="static/assets/css/responsive.css">
    <style>
        #main {
            height: calc(100% - 156px);
        }
    </style>
</head>
<body>

<section class="signin signup">
    <div class="container">
        <div class="sign-content" id="main">
            <h2>用户注册</h2>

            <div class="signin-form">
                <div class=" ">
                    <div class=" ">
                        <form action="UserServlet" id="form">
                            <input type="hidden" name="actionName" value="userRegister">
                            <div class="form-group">
                                <label for="signin_form1">用户名</label>
                                <input type="text" class="form-control" id="signin_form1"
                                       name="userName"
                                       value="${result.result.userName}"
                                       placeholder="请输入您的用户名">
                            </div><!--/.form-group -->
                            <div class="form-group">
                                <label for="signin_form2">密码</label>
                                <input type="password" class="form-control" id="signin_form2"
                                       name="password"
                                       value="${result.result.password}"
                                       placeholder="请输入密码">
                            </div><!--/.form-group -->
                            <div class="form-group">
                                <label for="signin_form3">确认密码</label>
                                <input type="password" class="form-control" id="signin_form3"
                                       name="rePassword"
                                       placeholder="请确认您输入的密码">
                            </div>
                        </form>
                    </div>
                </div>

            </div>
            <div class="signin-footer">
                <span id="errMsg" style="color: red; font-size: 12px">${result.message}</span>
                <button type="button" class="btn signin_btn signin_btn_two" data-toggle="modal"
                        data-target=".signin_modal" onclick="registerUser()">
                    注册
                </button>
            </div>

        </div>
    </div>

</section>
<script>
    function registerUser() {
        const userName = $("#signin_form1").val()
        const password = $("#signin_form2").val()
        const rePassword = $("#signin_form3").val()

        const msg = $("#errMsg")

        const uPattern = /^[a-zA-Z0-9_-]{4,16}$/;
        const pPattern = /^[a-zA-Z0-9_-]{6,16}$/;
        if (!uPattern.test(userName)) {
            msg.html("用户名不能为空,且必须为4-16位数字,字母或者下划线")
            return
        }
        if (!pPattern.test(password)) {
            msg.html("密码不能为空,且必须为6-16位数字,字母或者下划线")
            return
        }
        if (rePassword.trim() === "") {
            msg.html("请再次输入密码")
            return;
        }
        if (password !== rePassword) {
            msg.html("两次密码输入不一致,请再次输入!")
            return
        }
        msg.html("")
        $("#form").submit()
    }
</script>
<script src="static/assets/js/jquery.js"></script>

<!--bootstrap.min.js-->
<script src="static/assets/js/bootstrap.min.js"></script>

<!-- bootsnav js -->
<script src="static/assets/js/bootsnav.js"></script>

<!-- jquery.sticky.js -->
<script src="static/assets/js/jquery.sticky.js"></script>

<!--Custom JS-->
<script src="static/assets/js/custom.js"></script>

</body>
</html>
