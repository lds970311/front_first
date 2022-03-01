<%--
  Created by IntelliJ IDEA.
  User: mechrevo
  Date: 2022-02-27
  Time: 22:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>用户登录</title>
    <link href="static/css/login.css" rel="stylesheet" type="text/css"/>
    <script src="static/js/jquery-1.11.3.js" type=text/javascript></script>
    <script src="static/js/config.js" type=text/javascript></script>
    <script src="static/js/login.js"></script>
</head>
<body>
<!--head-->
<div id="head">
    <div class="top">
        <div class="fl yahei18">开启移动办公新时代！</div>
    </div>
</div>

<!--login box-->
<div class="wrapper">
    <div id="box">
        <div class="loginbar">用户登录</div>
        <div id="tabcon">
            <div class="box show">
                <form action="UserServlet" method="post" id="login-form">
                    <%--隐藏域,用于区分不同功能,表示用户行为--%>
                    <input type="hidden" name="actionName" value="login">
                    <label for="UserName">
                        <input type="text" name="userName" class="user yahei16" id="UserName"
                               value="${resultInfo.result.uname}"/>
                        <br/>
                        <br/>
                    </label>
                    <label for="UserPwd">
                        <input type="password" name="password" class="pwd yahei16" id="UserPwd"
                               value="${resultInfo.result.upwd}"/>
                        <br/>
                        <br/>
                    </label>
                    <label>
                        <input name="isChecked" type="checkbox" value="" class="inputcheckbox"/>
                    </label>
                    <label>记住我</label>&nbsp; &nbsp;
                    <span id="Msg">${resultInfo.message}</span>
                    <br/><br/>
                    <input type="button" class="log jc yahei16" value="登 录" onclick="checkLogin()"/>&nbsp; &nbsp; &nbsp;
                    <input type="reset" value="取 消" class="reg jc yahei18"/>
                </form>
            </div>
        </div>
    </div>
</div>

<div id="flash">
    <div class="pos">
        <a bgUrl="static/images/banner-bg1.jpg" id="flash1" style="display:block;">
            <img src="static/images/banner_pic1.png" alt="呵呵">
        </a>
        <a bgUrl="static/images/banner-bg2.jpg" id="flash2">
            <img src="static/images/banner-pic2.jpg" alt="哈哈">
        </a>
    </div>
    <div class="flash_bar">
        <div class="dq" id="f1" onclick="changeFlash(1)"></div>
        <div class="no" id="f2" onclick="changeFlash(2)"></div>
    </div>
</div>

<!--bottom-->
<div id="bottom">
    <div id="copyright">
        <div class="quick">
            <ul>
                <li>
                    <input type="button" class="quickbd iphone" onclick="location.href='https://github.com/lds970311'"/>
                </li>
                <li>
                    <input type="button" class="quickbd android" onclick="location.href='https://juejin.cn/'"/>
                </li>
                <li>
                    <input type="button" class="quickbd pc" onclick="location.href='https://www.baidu.com'"/>
                </li>
                <div class="clr"></div>
            </ul>
            <div class="clr"></div>
        </div>
        <div class="text">
            Copyright © 2006-2026
            <a href="https://github.com/lds970311">directed by evan lee</a>
            All Rights Reserved
        </div>
    </div>
</div>
</body>
</html>
